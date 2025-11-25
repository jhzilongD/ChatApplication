package com.seudjh.chatapplication.authenticationservice.controller;


import com.seudjh.chatapplication.authenticationservice.common.Result;
import com.seudjh.chatapplication.authenticationservice.data.user.common.sms.SMSRequest;
import com.seudjh.chatapplication.authenticationservice.data.user.common.sms.SMSResponse;
import com.seudjh.chatapplication.authenticationservice.data.user.common.uploadUrl.UploadUrlRequest;
import com.seudjh.chatapplication.authenticationservice.data.user.common.uploadUrl.UploadUrlResponse;
import com.seudjh.chatapplication.authenticationservice.data.user.register.RegisterRequest;
import com.seudjh.chatapplication.authenticationservice.data.user.register.RegisterResponse;
import com.seudjh.chatapplication.authenticationservice.service.CommonService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/api/v1/user/common")
public class CommonController {
    @Autowired
    private CommonService commonService;

    @GetMapping("/sms")    // 原来是发送手机短信，现在改成发邮箱，所以phone字段 存储 邮箱哈哈 , phone 就是邮箱
    public Result<String> sendSms(@RequestParam("phone") String phone){ // 这里到时候可能有坑，记得排查，原来的sms是用body接的
        commonService.sendMail(phone);
        return Result.OK("邮箱发送成功");
    }

    @GetMapping("/uploadUrl")
    public Result<UploadUrlResponse> uploadUrl(@Valid UploadUrlRequest uploadUrlRequest) throws Exception{
        UploadUrlResponse uploadUrlResponse = commonService.uploadUrl(uploadUrlRequest);

        return Result.OK(uploadUrlResponse);
    }

}
