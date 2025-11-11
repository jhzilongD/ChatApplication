package com.seudjh.chatapplication.authenticationservice.utils;

import java.util.Random;

public class NickNameGenaratorUtil {

    static String[] adjectives = {"粘人的", "狗日的"};

    static String[] animals = {"狗", "猫", "龙", "蛇", "鸡子"};

    public static String generateNickName(){
        Random random = new Random();
        String adj = adjectives[random.nextInt(adjectives.length)];
        String animal = animals[random.nextInt(animals.length)];
        return adj + animal;

    }
}
