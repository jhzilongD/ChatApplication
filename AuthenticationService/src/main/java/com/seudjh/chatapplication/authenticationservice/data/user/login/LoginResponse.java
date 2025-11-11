package com.seudjh.chatapplication.authenticationservice.data.user.login;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LoginResponse {
    private String userId;
    private String userName;
    private String token;
    private String signature;
    private Integer gender;
    private Integer Status;
    private String nettyUrl;
    private String avatar;
}
