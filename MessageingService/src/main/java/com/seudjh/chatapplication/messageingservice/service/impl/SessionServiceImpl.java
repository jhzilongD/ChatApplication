package com.seudjh.chatapplication.messageingservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.seudjh.chatapplication.messageingservice.model.Session;
import com.seudjh.chatapplication.messageingservice.service.SessionService;
import com.seudjh.chatapplication.messageingservice.mapper.SessionMapper;
import org.springframework.stereotype.Service;

/**
* @author seudmax
* @description 针对表【session(会话表)】的数据库操作Service实现
* @createDate 2025-12-06 16:52:01
*/
@Service
public class SessionServiceImpl extends ServiceImpl<SessionMapper, Session>
    implements SessionService{

}




