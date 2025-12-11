package com.seudjh.chatapplication.realtimecommunicationservice.websocket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler.Sharable;

import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Sharable
public class NettyUtils {
    // 为每个 WebSocket 连接（Channel）绑定用户级元数据（如 token、UID），并在整个连接生命周期内方便地访问这些数据。
    public static AttributeKey<String> TOKEN = AttributeKey.valueOf("token");

    public static AttributeKey<String> UID = AttributeKey.valueOf("userUuid");

    public static AttributeKey<WebSocketServerHandshaker> HANDSHAKE_ATTR_KEY = AttributeKey.valueOf(WebSocketServerHandshaker.class, "HANDSHAKE");

    public static <T> void setAttr(Channel channel, AttributeKey<T> attributeKey, T data) {
        channel.attr(attributeKey).set(data);
    }

    public static <T> T getAttr(Channel channel, AttributeKey<T> attributeKey) {
        return channel.attr(attributeKey).get();
    }
}
