package com.seudjh.chatapplication.messageingservice.mapper;

import com.seudjh.chatapplication.messageingservice.model.RedPacketReceive;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author seudmax
* @description 针对表【red_packet_receive(红包领取记录表)】的数据库操作Mapper
* @createDate 2025-12-12 23:04:13
* @Entity com.seudjh.chatapplication.messageingservice.model.RedPacketReceive
*/
@Mapper
public interface RedPacketReceiveMapper extends BaseMapper<RedPacketReceive> {

    @Select("SELECT * FROM red_packet_receive WHERE red_packet_id = #{redPacketId} " +
            "LIMIT #{pageNum}, #{pageSize}")
    List<RedPacketReceive> selectByRedPacketId(@Param("redPacketId") Long redPacketId,
                                               @Param("pageNum") Integer pageNum,
                                               @Param("pageSize") Integer pageSize);
}




