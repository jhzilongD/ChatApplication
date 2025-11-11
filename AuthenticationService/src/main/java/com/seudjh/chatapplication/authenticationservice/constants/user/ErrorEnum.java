package com.seudjh.chatapplication.authenticationservice.constants.user;

import lombok.Data;


public enum ErrorEnum {
    // 400 用户类异常
    SUCCESS(200, "ok"),
    REGISTER_ERROR(40001, "注册失败,用户已经存在"),
    LOGIN_ERROR(40003, "登陆异常"),
    CODE_ERROR(40002, "验证码错误"),
    // 500 服务端异常
    SYSTEM_ERROR(50001, "服务端异常");

    private final int code;
    private final String message;
    ErrorEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }

}
