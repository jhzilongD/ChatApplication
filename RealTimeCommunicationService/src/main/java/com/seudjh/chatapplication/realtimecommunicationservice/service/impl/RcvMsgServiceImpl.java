package com.seudjh.chatapplication.realtimecommunicationservice.service.impl;

import com.seudjh.chatapplication.realtimecommunicationservice.constants.MessageRcvTypeEnum;
import com.seudjh.chatapplication.realtimecommunicationservice.data.ReceiveMessage.ReceiveMessageRequest;
import com.seudjh.chatapplication.realtimecommunicationservice.data.ReceiveMessage.ReceiveMessageResponse;
import com.seudjh.chatapplication.realtimecommunicationservice.service.RcvMsgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RcvMsgServiceImpl implements RcvMsgService {
    @Autowired
    private NettyMessageService nettyMessageService;

    @Override
    public ReceiveMessageResponse receiveMessage(ReceiveMessageRequest request) {
        nettyMessageService.sendMessageToUser(request);

        return new ReceiveMessageResponse();
    }
}
