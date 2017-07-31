package com.beleco.gameofwar.redis.dao;

import com.beleco.gameofwar.domain.game.Board;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;

/**
 * Created by Everdark on 31.07.2017.
 */
public class SimpleGameDAO implements GameDAO{

    @Autowired
    private Jedis jedis;

    @Override
    public String getUsername(String userId) {
        return null;
    }

    @Override
    public Board getUserBoard(String userId) {
        return null;
    }

    @Override
    public void setBoard(String userId, Board board) {

    }
}
