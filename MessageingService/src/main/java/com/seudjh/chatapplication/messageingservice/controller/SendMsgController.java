package com.seudjh.chatapplication.messageingservice.controller;

import com.seudjh.chatapplication.messageingservice.common.Result;
import com.seudjh.chatapplication.messageingservice.data.receiveRedPackage.ReceiveRedPacketRequest;
import com.seudjh.chatapplication.messageingservice.data.receiveRedPackage.ReceiveRedPacketResponse;
import com.seudjh.chatapplication.messageingservice.data.sendMsg.SendMsgRequest;
import com.seudjh.chatapplication.messageingservice.data.sendMsg.SendMsgResponse;
import com.seudjh.chatapplication.messageingservice.feign.ContactServiceFeigh;
import com.seudjh.chatapplication.messageingservice.service.MessageService;
import com.seudjh.chatapplication.messageingservice.service.RedPacketReceiveService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class SendMsgController {
    @Autowired
    private ContactServiceFeigh contactServiceFeigh;
    @Autowired
    private MessageService messageService;

    @PostMapping("/v1/chat/session")
    public Result<SendMsgResponse>  sendMsg(@RequestBody SendMsgRequest request) {
        SendMsgResponse sendMsgResponse = messageService.sendMessage(request);
        return Result.OK(sendMsgResponse);
    }

}
