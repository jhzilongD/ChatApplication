package com.seudjh.chatapplication.authenticationservice.data.user.register;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RegisterRequest {
    private String phone;
    private String password;
    private String code;
}
