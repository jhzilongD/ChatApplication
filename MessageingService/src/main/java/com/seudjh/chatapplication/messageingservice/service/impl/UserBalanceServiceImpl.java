package com.seudjh.chatapplication.messageingservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seudjh.chatapplication.messageingservice.model.UserBalance;
import com.seudjh.chatapplication.messageingservice.service.UserBalanceService;
import com.seudjh.chatapplication.messageingservice.mapper.UserBalanceMapper;
import org.springframework.stereotype.Service;

/**
* @author seudmax
* @description 针对表【user_balance(用户余额表)】的数据库操作Service实现
* @createDate 2025-12-12 22:37:19
*/
@Service
public class UserBalanceServiceImpl extends ServiceImpl<UserBalanceMapper, UserBalance>
    implements UserBalanceService{

}




