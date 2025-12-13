package com.seudjh.chatapplication.messageingservice.service;

import com.seudjh.chatapplication.messageingservice.data.receiveRedPackage.ReceiveRedPacketResponse;
import com.seudjh.chatapplication.messageingservice.model.RedPacket;
import com.seudjh.chatapplication.messageingservice.model.RedPacketReceive;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author seudmax
* @description 针对表【red_packet_receive(红包领取记录表)】的数据库操作Service
* @createDate 2025-12-12 23:04:13
*/
public interface RedPacketReceiveService extends IService<RedPacket> {

    ReceiveRedPacketResponse receiveRedPacket(Long userId, Long redPacketId);
}
