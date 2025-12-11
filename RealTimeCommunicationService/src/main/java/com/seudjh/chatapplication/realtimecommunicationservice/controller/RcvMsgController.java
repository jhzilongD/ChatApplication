package com.seudjh.chatapplication.realtimecommunicationservice.controller;


import com.alibaba.nacos.shaded.com.google.protobuf.Message;
import com.seudjh.chatapplication.realtimecommunicationservice.common.Result;
import com.seudjh.chatapplication.realtimecommunicationservice.data.ReceiveMessage.ReceiveMessageRequest;
import com.seudjh.chatapplication.realtimecommunicationservice.data.ReceiveMessage.ReceiveMessageResponse;
import com.seudjh.chatapplication.realtimecommunicationservice.service.RcvMsgService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/message/user")
@Slf4j
@RequiredArgsConstructor
public class RcvMsgController {

    @Autowired
    RcvMsgService rcvMsgService;

    @PostMapping
    public Result<ReceiveMessageResponse> receiveMessage(@Valid @RequestBody ReceiveMessageRequest receiveMessageRequest){
        ReceiveMessageResponse response = rcvMsgService.receiveMessage(receiveMessageRequest);
        return null;
    }
}
