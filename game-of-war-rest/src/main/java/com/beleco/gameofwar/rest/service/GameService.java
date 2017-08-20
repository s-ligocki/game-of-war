package com.beleco.gameofwar.rest.service;

import com.beleco.gameofwar.domain.exception.GameException;
import com.beleco.gameofwar.domain.domain.Board;
import com.beleco.gameofwar.domain.domain.GameState;
import com.beleco.gameofwar.domain.domain.ReturnStatus;
import com.beleco.gameofwar.domain.domain.UserID;

/**
 * Created by Everdark on 13.06.2017.
 */
public interface GameService {

    UserID login(String username) throws GameException;

    ReturnStatus reset(String userId) throws GameException;

    GameState getGameState(String userId) throws GameException;

    Board getBoardState(String userId) throws GameException;

    ReturnStatus play(Board board, String userId) throws GameException;
}
