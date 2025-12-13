package com.seudjh.chatapplication.messageingservice.mapper;

import com.seudjh.chatapplication.messageingservice.model.BalanceLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author seudmax
* @description 针对表【balance_log(余额变动记录表)】的数据库操作Mapper
* @createDate 2025-12-12 22:37:19
* @Entity com.seudjh.chatapplication.messageingservice.model.BalanceLog
*/
@Mapper
public interface BalanceLogMapper extends BaseMapper<BalanceLog> {

}




