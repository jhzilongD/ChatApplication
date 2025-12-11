package com.seudjh.chatapplication.realtimecommunicationservice.websocket;

import io.netty.channel.Channel;

import java.util.concurrent.ConcurrentHashMap;

public class ChannelManager {
    private static final ConcurrentHashMap<String, Channel> USER_CHANNEL_MAP =
            new ConcurrentHashMap<String, Channel>();

    private static final ConcurrentHashMap<Channel, String> CHANNEL_USER_MAP =
            new ConcurrentHashMap<Channel, String>();

    public static void addUserChannel(String UserUuid, Channel channel) {
        USER_CHANNEL_MAP.put(UserUuid, channel);
    }

    public static void removeUserChannel(String UserUuid) {
        USER_CHANNEL_MAP.remove(UserUuid);
    }

    public static Channel getChannelByUserId(String UserUuid) {
        return USER_CHANNEL_MAP.get(UserUuid);
    }


    public static void addChannelUser(String UserUuid, Channel channel) {
        CHANNEL_USER_MAP.put(channel, UserUuid);

    }

    public static void removeChannelUser(Channel channel) {
        CHANNEL_USER_MAP.remove(channel);
    }
    public static String getUserByChannel(Channel channel) {
        return CHANNEL_USER_MAP.get(channel);
    }
}
