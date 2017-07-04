package com.beleco.gameofwar.service;

import com.beleco.gameofwar.domain.game.Board;
import com.beleco.gameofwar.domain.game.GameState;
import com.beleco.gameofwar.domain.game.UserID;
import com.beleco.gameofwar.exception.GameException;
import com.beleco.gameofwar.exception.NotValidBoardExcepiton;
import com.beleco.gameofwar.exception.NotValidUsernameException;
import com.beleco.gameofwar.exception.NotValidUserIdException;

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
