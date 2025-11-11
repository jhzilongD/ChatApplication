package com.seudjh.chatapplication.authenticationservice.exception;

import com.seudjh.chatapplication.authenticationservice.constants.user.ErrorEnum;

public class CodeException extends RuntimeException {
    private final int code;


    public CodeException(String message) {
        super(message);
        this.code = ErrorEnum.SYSTEM_ERROR.getCode();
    }
    public CodeException(String message, int code) {
        super(message);
        this.code = code;
    }

    public CodeException(ErrorEnum errorEnum) {
        super(errorEnum.getMessage());
        this.code = errorEnum.getCode();
    }

    public CodeException(ErrorEnum errorEnum,  String message) {
        super(message);
        this.code = errorEnum.getCode();
    }

    public int getCode() {
        return this.code;
    }
}
