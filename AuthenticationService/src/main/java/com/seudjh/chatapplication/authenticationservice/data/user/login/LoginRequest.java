package com.seudjh.chatapplication.authenticationservice.data.user.login;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

@Data
@Accessors(chain = true)
public class LoginRequest
{
    @NotEmpty(message = "邮箱不能为空")
    private String phone;

    @NotEmpty(message = "密码不能为空")
    private String password;
}
