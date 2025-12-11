package com.seudjh.chatapplication.messageingservice.feign;


import com.seudjh.chatapplication.messageingservice.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("ContactService")
public interface ContactServiceFeigh {

    @GetMapping("/api/v1/contact/user")
    Result<?> getUser();
}
