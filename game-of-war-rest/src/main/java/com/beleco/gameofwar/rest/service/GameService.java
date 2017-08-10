package com.beleco.gameofwar.rest.service;

import com.beleco.gameofwar.rest.domain.game.Board;
import com.beleco.gameofwar.rest.domain.game.GameState;
import com.beleco.gameofwar.rest.domain.game.UserID;
import com.beleco.gameofwar.rest.exception.GameException;
import com.beleco.gameofwar.rest.exception.NotValidBoardExcepiton;
import com.beleco.gameofwar.rest.exception.NotValidUsernameException;
import com.beleco.gameofwar.rest.exception.NotValidUserIdException;

/**
 * Created by Everdark on 13.06.2017.
 */
public interface GameService {

    UserID login(String username) throws GameException;

    void reset(String userId) throws GameException;

    GameState getGameState(String userId) throws GameException;

    Board getBoardState(String userId) throws GameException;

    void play(Board board, String userId) throws GameException;
}
