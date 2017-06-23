package com.beleco.gameofwar.util;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Everdark on 22.06.2017.
 */
public class EnumRandomizer<E extends Enum> {

    private final List<E> VALUES;
    private final int SIZE;
    private final Random RANDOM = new Random();

    public EnumRandomizer(Class<E> type) {
        VALUES = Arrays.asList((E[]) type.getEnumConstants());
        SIZE = VALUES.size();
    }

    public E getRandomValue(){
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
