package com.seudjh.chatapplication.authenticationservice.exception;

import com.seudjh.chatapplication.authenticationservice.constants.user.ErrorEnum;

public class DatabaseException extends RuntimeException {
    private final int code;


    public DatabaseException(String message) {
        super(message);
        this.code = ErrorEnum.SYSTEM_ERROR.getCode();
    }
    public DatabaseException(String message, int code) {
        super(message);
        this.code = code;
    }

    public DatabaseException(ErrorEnum errorEnum) {
        super(errorEnum.getMessage());
        this.code = errorEnum.getCode();
    }

    public DatabaseException(ErrorEnum errorEnum,  String message) {
        super(message);
        this.code = errorEnum.getCode();
    }

    public int getCode() {
        return this.code;
    }
}
