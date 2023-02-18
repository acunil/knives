package com.example.knives.util;

import com.example.knives.model.Knife;
import jakarta.validation.constraints.NotBlank;

import java.security.SecureRandom;
import java.util.UUID;

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

    public static Knife randomKnife(@NotBlank String name) {
        return new Knife(UUID.randomUUID(),
            name,
            RandomUtil.randomBladeLength(),
            randomEnum(Knife.KnifeType.class),
            randomEnum(Knife.BladeMaterial.class),
            randomEnum(Knife.HandleMaterial.class));
    }
}
