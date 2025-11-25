package com.seudjh.chatapplication.authenticationservice.service.impl;

import com.seudjh.chatapplication.authenticationservice.common.Result;
import com.seudjh.chatapplication.authenticationservice.constants.config.OSSConstant;
import com.seudjh.chatapplication.authenticationservice.constants.user.registerConstant;
import com.seudjh.chatapplication.authenticationservice.data.user.common.sms.SMSRequest;
import com.seudjh.chatapplication.authenticationservice.data.user.common.sms.SMSResponse;
import com.seudjh.chatapplication.authenticationservice.data.user.common.uploadUrl.UploadUrlRequest;
import com.seudjh.chatapplication.authenticationservice.data.user.common.uploadUrl.UploadUrlResponse;
import com.seudjh.chatapplication.authenticationservice.service.CommonService;
import com.seudjh.chatapplication.authenticationservice.utils.OSSUtil;
import com.seudjh.chatapplication.authenticationservice.utils.RamdomNumUtil;
import com.seudjh.chatapplication.authenticationservice.utils.SendMailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.concurrent.TimeUnit;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private OSSUtil oSSUtil;


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

    @Override
    public UploadUrlResponse uploadUrl(UploadUrlRequest uploadUrlRequest) throws Exception{
        String fileName = uploadUrlRequest.getFileName();
        // 参数：桶名、文件名、过期时间
        String uploadUrl = oSSUtil.uploadUrl(OSSConstant.BUCKET_NAME, fileName, OSSConstant.PICTURE_EXPIRATION_TIME);
        // 参数：桶名、文件名
        String downloadUrl = oSSUtil.downloadUrl(OSSConstant.BUCKET_NAME, fileName);
        UploadUrlResponse uploadUrlResponse = new UploadUrlResponse();
        uploadUrlResponse.setDownloadUrl(downloadUrl).setUploadUrl(uploadUrl);

        return uploadUrlResponse;
    }

}
