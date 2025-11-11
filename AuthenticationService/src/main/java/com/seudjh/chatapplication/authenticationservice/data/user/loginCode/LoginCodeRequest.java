package com.seudjh.chatapplication.authenticationservice.data.user.loginCode;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LoginCodeRequest {

    @NotEmpty(message = "邮箱不能为空")
    private String phone;


    @NotEmpty(message = "验证码不能为空")
    private String code;
}
