package com.beleco.gameofwar.core.exception;

import com.beleco.gameofwar.domain.exception.GameException;

/**
 * Created by Everdark on 24.06.2017.
 */
public class NotValidBoardException extends GameException {
    public NotValidBoardException(String message){
        super(message);
    }
}
