package com.seudjh.chatapplication.authenticationservice.data.user.common.uploadUrl;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UploadUrlRequest {

    @NotEmpty(message = "文件名不能为空")
    private String fileName;

}
