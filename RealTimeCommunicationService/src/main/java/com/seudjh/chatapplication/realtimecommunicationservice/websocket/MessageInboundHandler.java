package com.seudjh.chatapplication.realtimecommunicationservice.websocket;

import cn.hutool.json.JSONUtil;
import com.seudjh.chatapplication.realtimecommunicationservice.constants.MessageTypeEnum;
import com.seudjh.chatapplication.realtimecommunicationservice.constants.UserConstants;
import com.seudjh.chatapplication.realtimecommunicationservice.exception.MessageTypeException;
import com.seudjh.chatapplication.realtimecommunicationservice.model.AckData;
import com.seudjh.chatapplication.realtimecommunicationservice.model.LogOutData;
import com.seudjh.chatapplication.realtimecommunicationservice.model.MessageDTO;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.seudjh.chatapplication.realtimecommunicationservice.utils.JwtUtil;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.net.InetAddress;


@Slf4j
@ChannelHandler.Sharable
@AllArgsConstructor
public class MessageInboundHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private StringRedisTemplate redisTemplate;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        log.info("Receive message: {}", msg.text());

        MessageDTO messageDTO = JSONUtil.toBean(msg.text(), MessageDTO.class);

        MessageTypeEnum messageType = MessageTypeEnum.of(messageDTO.getType());
        switch (messageType) {
            case ACK:
                processACK(messageDTO);
            case LOG_OUT:
                processLogOut(ctx, messageDTO);
            case HEART_BEAT:
                processHeartBeat(ctx, messageDTO);

            default:
                processIllegal(messageDTO);
        }
        // ack
        // HEART_BEAT
        // LOG_OUT
    }

    private void processIllegal(MessageDTO messageDTO) {
        throw new MessageTypeException("Illegal message type");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        log.error("Exception caught", cause);
        try {
            offline(ctx);
        } catch (Exception e) {
            log.error("关闭管道失败", e);
        }

    }

    private void processHeartBeat(ChannelHandlerContext ctx, MessageDTO msg) {
        log.info("Receive heart beat message");
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setType(MessageTypeEnum.HEART_BEAT.getCode());
        TextWebSocketFrame frame = new TextWebSocketFrame(JSONUtil.toJsonStr(messageDTO));
        ctx.channel().writeAndFlush(frame);
    }



    private void processLogOut(ChannelHandlerContext ctx, MessageDTO msg) throws Exception {
        LogOutData logOutData = JSONUtil.toBean(msg.getData().toString(), LogOutData.class);
        Integer userUuid = logOutData.getUserUuid();
        log.info("请求断开用户{}的连接...", userUuid);
        offline(ctx);
        log.info("断开连接成功");


    }

    private void processACK(MessageDTO msg) {
        AckData ackData = JSONUtil.toBean(msg.getData().toString(), AckData.class);
        log.info("Receive ack: {}", ackData);
        log.info("消息推送成功");

    }
    // 用户上线，管道打开时调用
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("web_socket 建立");
    }
    // 管道关闭时调用
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        offline(ctx);
        super.channelInactive(ctx);
    }


    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        // 处理心跳
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            switch (event.state()) {
                case READER_IDLE:
                    log.error("读空闲超时，关闭连接...{}, 用户id: {}", ctx.channel().remoteAddress(),
                            ChannelManager.getUserByChannel(ctx.channel()));
                    offline(ctx);
                    break;
                case WRITER_IDLE:
                    log.error("写空闲超时");
                case ALL_IDLE:
                    log.error("读写空闲超时");

            }
        }

        // 处理握手， 协议升级
        if (evt instanceof WebSocketServerProtocolHandler.HandshakeComplete) {
            String token = NettyUtils.getAttr(ctx.channel(), NettyUtils.TOKEN);
            String userUuid = NettyUtils.getAttr(ctx.channel(), NettyUtils.UID);

            if (!validateToken(userUuid, token)) {
                log.info("token invalid");
                ctx.close();
                return;
            }

            redisTemplate.opsForValue().set(UserConstants.USER_SESSION + userUuid, InetAddress.getLocalHost().getHostAddress());

            Channel channel = ChannelManager.getChannelByUserId(userUuid);
            if (channel != null) {
                ChannelManager.removeUserChannel(userUuid);
                ChannelManager.removeChannelUser(channel);
                channel.close();
            }

            ChannelManager.addUserChannel(userUuid, ctx.channel());
            ChannelManager.addChannelUser(userUuid, ctx.channel());
            log.info("客户端连接成功， 用户ID：{}", userUuid + "管道地址：" + ctx.channel().remoteAddress());

        }
    }

    // 下线函数
    private void offline(ChannelHandlerContext ctx) throws Exception {
        String userId = ChannelManager.getUserByChannel(ctx.channel());

        try {
            ChannelManager.removeChannelUser(ctx.channel());
            if (userId != null) {
                ChannelManager.removeUserChannel(userId);
                log.info("客户端关闭连接，userid：{}, 客户端地址：{}",  userId, ctx.channel().remoteAddress());
            }
        } catch (Exception e) {
            log.error("处理退出登陆异常", e);
        } finally {
            if (ctx.channel() != null) {
                ctx.channel().close();
            }
            redisTemplate.opsForValue().getAndDelete(UserConstants.USER_SESSION + userId);
        }

    }

    private boolean validateToken(String userUuid, String token) {
        String userId = JwtUtil.getUserIdFromToken(token);
        if (userId == null || !userId.equals(userUuid)) {
            return false;
        }
        return true;

    }
}
