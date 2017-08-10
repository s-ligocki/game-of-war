package com.beleco.gameofwar.rest.service;

import com.beleco.gameofwar.core.domain.*;
import com.beleco.gameofwar.core.exception.GameException;

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
