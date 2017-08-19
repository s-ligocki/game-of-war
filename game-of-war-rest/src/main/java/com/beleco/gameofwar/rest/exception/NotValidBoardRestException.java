package com.beleco.gameofwar.rest.exception;

import com.beleco.gameofwar.core.exception.GameException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Everdark on 24.06.2017.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Wrong input parameter")
public class NotValidBoardRestException extends GameException {
    public NotValidBoardRestException(String message){
        super(message);
    }
}
