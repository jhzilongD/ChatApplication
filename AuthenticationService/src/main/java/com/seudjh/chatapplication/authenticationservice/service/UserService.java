package com.seudjh.chatapplication.authenticationservice.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.seudjh.chatapplication.authenticationservice.data.user.common.updateAvatar.UpdateAvatarRequest;
import com.seudjh.chatapplication.authenticationservice.data.user.common.updateAvatar.UpdateAvatarResponse;
import com.seudjh.chatapplication.authenticationservice.data.user.login.LoginRequest;
import com.seudjh.chatapplication.authenticationservice.data.user.login.LoginResponse;
import com.seudjh.chatapplication.authenticationservice.data.user.loginCode.LoginCodeRequest;
import com.seudjh.chatapplication.authenticationservice.data.user.loginCode.LoginCodeResponse;
import com.seudjh.chatapplication.authenticationservice.data.user.register.RegisterRequest;
import com.seudjh.chatapplication.authenticationservice.data.user.register.RegisterResponse;
import com.seudjh.chatapplication.authenticationservice.model.User;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.validation.Valid;

/**
* @author seudmax
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2025-11-09 19:56:42
*/
public interface UserService extends IService<User> {
    default User getOnly(QueryWrapper<User> wrapper, boolean throwEx) {
        wrapper.last("limit 1");

        return this.getOne(wrapper, throwEx);

    }

    RegisterResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest loginRequest);


    LoginCodeResponse loginCode(LoginCodeRequest loginCodeRequest);

    UpdateAvatarResponse updateAvatar(String id, UpdateAvatarRequest updateAvatarRequest);
}
