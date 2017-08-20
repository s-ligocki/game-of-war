package com.beleco.gameofwar.rest.util;

import com.beleco.gameofwar.domain.domain.UserID;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by Everdark on 20.08.2017.
 */
@Component
public class UserIDGeneratorSingleton {

    private static UserIDGeneratorSingleton INSTANCE;

    private int currentID;

    private UserIDGeneratorSingleton() {
        currentID = 0;
    }

    public static UserIDGeneratorSingleton getInstance(){
        if(INSTANCE==null){
            INSTANCE = new UserIDGeneratorSingleton();
        }
        return INSTANCE;
    }

    public UserID getNextID(){
        currentID++;
        return new UserID("USER_" + currentID);
    }
}
