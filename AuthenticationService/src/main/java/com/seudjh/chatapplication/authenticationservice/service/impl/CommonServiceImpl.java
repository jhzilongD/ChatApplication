package com.seudjh.chatapplication.authenticationservice.service.impl;

import com.seudjh.chatapplication.authenticationservice.constants.user.registerConstant;
import com.seudjh.chatapplication.authenticationservice.data.user.common.sms.SMSRequest;
import com.seudjh.chatapplication.authenticationservice.data.user.common.sms.SMSResponse;
import com.seudjh.chatapplication.authenticationservice.service.CommonService;
import com.seudjh.chatapplication.authenticationservice.utils.RamdomNumUtil;
import com.seudjh.chatapplication.authenticationservice.utils.SendMailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public SMSResponse sendSMS(SMSRequest smsRequest) {
        return null;

    }

    @Override
    public void sendMail(String phone) {
        String code = RamdomNumUtil.generateRamdomNum();
        SendMailUtil.sendEmailCode(phone, code);
        stringRedisTemplate.opsForValue().set(registerConstant.REGISTER_CODE + phone , code, 5, TimeUnit.MINUTES);
    }

}
