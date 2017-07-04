package com.beleco.gameofwar.service;

import com.beleco.gameofwar.domain.game.Board;
import com.beleco.gameofwar.domain.game.GameState;
import com.beleco.gameofwar.exception.NotValidBoardExcepiton;
import com.beleco.gameofwar.exception.NotValidUsernameException;
import com.beleco.gameofwar.exception.NotValidUserIdException;

/**
 * Created by Everdark on 13.06.2017.
 */
public interface GameService {

    String login(String username) throws NotValidUsernameException;

    void reset(String userId) throws NotValidUserIdException;

    GameState getGameState(String userId) throws NotValidUserIdException;

    Board getBoardState(String userId) throws NotValidUserIdException;

    void play(Board board) throws NotValidBoardExcepiton;
}
