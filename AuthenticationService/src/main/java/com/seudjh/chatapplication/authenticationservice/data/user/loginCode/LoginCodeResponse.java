package com.seudjh.chatapplication.authenticationservice.data.user.loginCode;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LoginCodeResponse {
    private String userId;
    private String userName;
    private String token;
    private String signature;
    private Integer gender;
    private Integer Status;
    private String nettyUrl;
    private String avatar;
}
