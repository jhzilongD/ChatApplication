package com.seudjh.chatapplication.authenticationservice.utils;

import java.util.Random;

public class RamdomNumUtil {
    public static String generateRamdomNum(){
        Random random = new Random();
        int num = random.nextInt(900000) + 100000;
        return String.valueOf(num);
    }
}
