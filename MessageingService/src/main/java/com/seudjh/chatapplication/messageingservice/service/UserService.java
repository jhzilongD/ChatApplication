package com.seudjh.chatapplication.messageingservice.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.seudjh.chatapplication.messageingservice.model.User;
import org.springframework.stereotype.Service;

/**
* @author seudmax
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2025-12-06 16:52:01
*/
@Service
public interface UserService extends IService<User> {

}
