package com.beleco.gameofwar.rest.service;

import com.beleco.gameofwar.core.domain.Board;
import com.beleco.gameofwar.core.domain.GameState;
import com.beleco.gameofwar.core.domain.ReturnStatus;
import com.beleco.gameofwar.core.domain.UserID;
import com.beleco.gameofwar.core.exception.GameException;
import com.beleco.gameofwar.core.login.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Everdark on 19.08.2017.
 */
@Component
public class SimpleGameService implements GameService {

    @Autowired
    private LoginUtil loginUtil;

    @Override
    public UserID login(String username) throws GameException {
        return loginUtil.performLogin(username);
    }

    @Override
    public ReturnStatus reset(String userId) throws GameException {
        return null;
    }

    @Override
    public GameState getGameState(String userId) throws GameException {
        return null;
    }

    @Override
    public Board getBoardState(String userId) throws GameException {
        return null;
    }

    @Override
    public ReturnStatus play(Board board, String userId) throws GameException {
        return null;
    }
}
