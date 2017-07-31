package com.beleco.gameofwar.redis.dao;

import com.beleco.gameofwar.domain.game.Board;

/**
 * Created by Everdark on 31.07.2017.
 */
public interface GameDAO {

    String getUsername(String userId);

    Board getUserBoard(String userId);

    void setBoard(String userId, Board board);
}
