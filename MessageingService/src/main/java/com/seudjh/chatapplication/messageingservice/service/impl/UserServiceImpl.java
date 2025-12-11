package com.seudjh.chatapplication.messageingservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.seudjh.chatapplication.messageingservice.model.User;
import com.seudjh.chatapplication.messageingservice.service.UserService;
import com.seudjh.chatapplication.messageingservice.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author seudmax
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2025-12-06 16:52:01
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




