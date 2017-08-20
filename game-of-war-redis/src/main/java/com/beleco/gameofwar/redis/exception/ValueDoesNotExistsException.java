package com.beleco.gameofwar.redis.exception;

import com.beleco.gameofwar.domain.exception.GameException;

/**
 * Created by Everdark on 20.08.2017.
 */
public class ValueDoesNotExistsException extends GameException {
    public ValueDoesNotExistsException(String message){
        super(message);
    }
}
