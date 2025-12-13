package com.seudjh.chatapplication.messageingservice.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seudjh.chatapplication.messageingservice.model.RedPacket;
import org.apache.ibatis.annotations.Mapper;

/**
* @author seudmax
* @description 针对表【red_packet(红包主表)】的数据库操作Mapper
* @createDate 2025-12-12 22:20:18
* @Entity generator.domain.RedPacket
*/
@Mapper
public interface RedPacketMapper extends BaseMapper<RedPacket> {

}




