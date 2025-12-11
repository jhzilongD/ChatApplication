package com.seudjh.chatapplication.messageingservice.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.seudjh.chatapplication.messageingservice.data.sendMsg.SendMsgRequest;
import com.seudjh.chatapplication.messageingservice.data.sendMsg.SendMsgResponse;
import com.seudjh.chatapplication.messageingservice.model.Message;
import org.springframework.stereotype.Service;

/**
* @author seudmax
* @description 针对表【message】的数据库操作Service
* @createDate 2025-12-06 16:52:01
*/

public interface MessageService extends IService<Message> {

    SendMsgResponse sendMessage(SendMsgRequest request);
}
