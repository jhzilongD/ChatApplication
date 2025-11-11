package com.seudjh.chatapplication.authenticationservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.seudjh.chatapplication.authenticationservice.data.user.common.sms.SMSRequest;
import com.seudjh.chatapplication.authenticationservice.data.user.common.sms.SMSResponse;
import com.seudjh.chatapplication.authenticationservice.data.user.register.RegisterRequest;
import com.seudjh.chatapplication.authenticationservice.data.user.register.RegisterResponse;
import com.seudjh.chatapplication.authenticationservice.model.User;
import org.springframework.web.bind.annotation.RequestBody;

public interface CommonService {

    SMSResponse sendSMS(@RequestBody SMSRequest smsRequest);

    void sendMail(String phone);
}

