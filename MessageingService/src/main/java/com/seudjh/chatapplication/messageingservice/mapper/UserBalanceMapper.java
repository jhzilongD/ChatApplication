package com.seudjh.chatapplication.messageingservice.mapper;

import com.seudjh.chatapplication.messageingservice.model.UserBalance;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author seudmax
* @description 针对表【user_balance(用户余额表)】的数据库操作Mapper
* @createDate 2025-12-12 22:37:19
* @Entity com.seudjh.chatapplication.messageingservice.model.UserBalance
*/
@Mapper
public interface UserBalanceMapper extends BaseMapper<UserBalance> {

}




