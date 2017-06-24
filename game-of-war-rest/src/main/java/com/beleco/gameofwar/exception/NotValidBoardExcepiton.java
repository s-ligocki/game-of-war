package com.beleco.gameofwar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Everdark on 24.06.2017.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Wrong input parameter")
public class NotValidBoardExcepiton extends Exception {
    public NotValidBoardExcepiton(String message){
        super(message);
    }
}
