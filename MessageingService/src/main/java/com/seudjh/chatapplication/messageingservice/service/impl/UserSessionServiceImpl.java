package com.seudjh.chatapplication.messageingservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.seudjh.chatapplication.messageingservice.model.UserSession;
import com.seudjh.chatapplication.messageingservice.service.UserSessionService;
import com.seudjh.chatapplication.messageingservice.mapper.UserSessionMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
* @author seudmax
* @description 针对表【user_session】的数据库操作Service实现
* @createDate 2025-12-06 16:52:01
*/
@Service
public class UserSessionServiceImpl extends ServiceImpl<UserSessionMapper, UserSession>
    implements UserSessionService{

    @Override
    public Collection<Long> getUserIdsBySessionId(Long sendUserId) {
        return List.of();
    }
}




