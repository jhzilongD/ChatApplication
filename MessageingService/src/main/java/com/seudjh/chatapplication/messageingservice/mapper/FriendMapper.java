package com.seudjh.chatapplication.messageingservice.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.seudjh.chatapplication.messageingservice.model.Friend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


/**
* @author seudmax
* @description 针对表【friend(联系人表)】的数据库操作Mapper
* @createDate 2025-12-06 16:52:01
* @Entity generator.domain.Friend
*/
@Mapper
public interface FriendMapper extends BaseMapper<Friend> {


    @Select("SELECT * FROM friend WHERE user_id = #{userId} AND friend_id = #{friendId} AND status = 1")
    Friend selectFriendship(@Param("userId") Long userId, @Param("friendId") Long friendId);
}




