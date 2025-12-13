package com.seudjh.chatapplication.messageingservice.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seudjh.chatapplication.messageingservice.model.Session;
import org.apache.ibatis.annotations.Mapper;

/**
* @author seudmax
* @description 针对表【session(会话表)】的数据库操作Mapper
* @createDate 2025-12-06 16:52:01
* @Entity generator.domain.Session
*/
@Mapper
public interface SessionMapper extends BaseMapper<Session> {

}




