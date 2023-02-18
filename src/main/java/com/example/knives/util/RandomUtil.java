package com.example.knives.util;

import java.security.SecureRandom;

public class RandomUtil {

    private RandomUtil() {
        //
    }

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        int x = SECURE_RANDOM.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    public static int randomInt(int min, int max) {
        return SECURE_RANDOM.nextInt((max - min) + 1) + min;
    }

    public static int randomBladeLength() {
        return randomInt(2, 30);
    }
}
