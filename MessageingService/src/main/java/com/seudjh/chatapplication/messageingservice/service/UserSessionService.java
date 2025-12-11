package com.seudjh.chatapplication.messageingservice.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.seudjh.chatapplication.messageingservice.model.UserSession;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
* @author seudmax
* @description 针对表【user_session】的数据库操作Service
* @createDate 2025-12-06 16:52:01
*/
public interface UserSessionService extends IService<UserSession> {
    Collection<Long> getUserIdsBySessionId(Long sendUserId);


}
