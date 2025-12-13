package com.seudjh.chatapplication.messageingservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.seudjh.chatapplication.messageingservice.model.BalanceLog;
import com.seudjh.chatapplication.messageingservice.service.BalanceLogService;
import com.seudjh.chatapplication.messageingservice.mapper.BalanceLogMapper;
import org.springframework.stereotype.Service;

/**
* @author seudmax
* @description 针对表【balance_log(余额变动记录表)】的数据库操作Service实现
* @createDate 2025-12-12 22:37:19
*/
@Service
public class BalanceLogServiceImpl extends ServiceImpl<BalanceLogMapper, BalanceLog>
    implements BalanceLogService{

}




