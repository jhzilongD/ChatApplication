package com.seudjh.chatapplication.messageingservice.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.seudjh.chatapplication.messageingservice.data.senRedPackage.SendRedPacketRequest;
import com.seudjh.chatapplication.messageingservice.data.senRedPackage.SendRedPacketResponse;
import com.seudjh.chatapplication.messageingservice.model.RedPacket;

/**
* @author seudmax
* @description 针对表【red_packet(红包主表)】的数据库操作Service
* @createDate 2025-12-12 22:20:18
*/
public interface RedPacketService extends IService<RedPacket> {
    /**
     * 发送红包
     * @param request
     * @return
     * @throws Exception
     */
    SendRedPacketResponse sendRedPacket(SendRedPacketRequest request) throws Exception;

    /**
     * 红包过期处理
     *
     * @param redPacketId 红包Id
     */
    void handleExpiredRedPacket(Long redPacketId);
}
