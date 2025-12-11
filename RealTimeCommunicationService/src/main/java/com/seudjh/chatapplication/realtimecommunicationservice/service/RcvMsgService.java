package com.seudjh.chatapplication.realtimecommunicationservice.service;

import com.seudjh.chatapplication.realtimecommunicationservice.data.ReceiveMessage.ReceiveMessageRequest;
import com.seudjh.chatapplication.realtimecommunicationservice.data.ReceiveMessage.ReceiveMessageResponse;

public interface RcvMsgService {
    ReceiveMessageResponse receiveMessage(ReceiveMessageRequest request);
}
