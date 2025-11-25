package com.seudjh.chatapplication.authenticationservice.data.user.common.uploadUrl;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UploadUrlResponse {


    public String uploadUrl;

    public String downloadUrl;
}
