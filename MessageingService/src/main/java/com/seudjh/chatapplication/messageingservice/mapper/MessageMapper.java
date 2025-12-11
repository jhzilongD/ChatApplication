package com.seudjh.chatapplication.messageingservice.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seudjh.chatapplication.messageingservice.model.Message;
import org.apache.ibatis.annotations.Mapper;

/**
* @author seudmax
* @description 针对表【message】的数据库操作Mapper
* @createDate 2025-12-06 16:52:01
* @Entity generator.domain.Message
*/
@Mapper
public interface MessageMapper extends BaseMapper<Message> {

}




