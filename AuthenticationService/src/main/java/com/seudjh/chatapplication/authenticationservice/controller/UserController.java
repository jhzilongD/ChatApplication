package com.seudjh.chatapplication.authenticationservice.controller;

import com.seudjh.chatapplication.authenticationservice.common.Result;
import com.seudjh.chatapplication.authenticationservice.data.user.common.updateAvatar.UpdateAvatarRequest;
import com.seudjh.chatapplication.authenticationservice.data.user.common.updateAvatar.UpdateAvatarResponse;
import com.seudjh.chatapplication.authenticationservice.data.user.login.LoginRequest;
import com.seudjh.chatapplication.authenticationservice.data.user.login.LoginResponse;
import com.seudjh.chatapplication.authenticationservice.data.user.loginCode.LoginCodeRequest;
import com.seudjh.chatapplication.authenticationservice.data.user.loginCode.LoginCodeResponse;
import com.seudjh.chatapplication.authenticationservice.data.user.register.RegisterRequest;
import com.seudjh.chatapplication.authenticationservice.data.user.register.RegisterResponse;
import com.seudjh.chatapplication.authenticationservice.service.UserService;
import com.seudjh.chatapplication.authenticationservice.utils.JwtUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result<RegisterResponse> register(@RequestBody RegisterRequest registerRequest){
        RegisterResponse response = userService.register(registerRequest);
        return Result.OK(response);
    }

    @PostMapping("/login")
    public Result<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse response = userService.login(loginRequest);
        return Result.OK(response);
    }

    @PostMapping("/loginCode")
    public Result<LoginCodeResponse> login(@RequestBody LoginCodeRequest loginCodeRequest) {
        LoginCodeResponse response = userService.loginCode(loginCodeRequest);
        return Result.OK(response);
    }

    @PatchMapping("/avatar")
    public Result<UpdateAvatarResponse> updateAvatar(@Valid @RequestBody UpdateAvatarRequest updateAvatarRequest,
                                                     @RequestHeader String Authorization) throws Exception {
        String id = JwtUtil.getUserIdFromToken(Authorization);
        UpdateAvatarResponse updateAvatarResponse = userService.updateAvatar(id, updateAvatarRequest);

        return Result.OK(updateAvatarResponse);
    }
}
