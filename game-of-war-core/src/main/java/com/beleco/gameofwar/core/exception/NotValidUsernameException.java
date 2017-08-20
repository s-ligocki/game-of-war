package com.beleco.gameofwar.core.exception;

import com.beleco.gameofwar.domain.exception.GameException;

/**
 * Created by Everdark on 04.07.2017.
 */
public class NotValidUsernameException extends GameException {
    public NotValidUsernameException(String message){
        super(message);
    }
}
