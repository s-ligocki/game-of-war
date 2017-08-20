package com.beleco.gameofwar.core.exception;

import com.beleco.gameofwar.domain.exception.GameException;

/**
 * Created by Everdark on 04.07.2017.
 */
public class NotValidUserIdException extends GameException {
    public NotValidUserIdException(String message){
        super(message);
    }
}
