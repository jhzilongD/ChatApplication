package com.seudjh.chatapplication.messageingservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.seudjh.chatapplication.messageingservice.model.Friend;
import com.seudjh.chatapplication.messageingservice.service.FriendService;
import com.seudjh.chatapplication.messageingservice.mapper.FriendMapper;
import org.springframework.stereotype.Service;

/**
* @author seudmax
* @description 针对表【friend(联系人表)】的数据库操作Service实现
* @createDate 2025-12-06 16:52:01
*/
@Service
public class FriendServiceImpl extends ServiceImpl<FriendMapper, Friend>
    implements FriendService{

}




