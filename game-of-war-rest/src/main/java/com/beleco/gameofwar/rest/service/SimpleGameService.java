package com.beleco.gameofwar.rest.service;

import com.beleco.gameofwar.domain.domain.Board;
import com.beleco.gameofwar.domain.domain.GameState;
import com.beleco.gameofwar.domain.domain.ReturnStatus;
import com.beleco.gameofwar.domain.domain.UserID;
import com.beleco.gameofwar.domain.exception.GameException;
import com.beleco.gameofwar.redis.service.LoginService;
import com.beleco.gameofwar.rest.util.UserIDGeneratorSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Everdark on 19.08.2017.
 */
@Component
public class SimpleGameService implements GameService {

    @Autowired
    private LoginService loginService;

    @Override
    public UserID login(String username) throws GameException {
        if(loginService.userExists(username)){
            return loginService.getUserIdByUsername(username);
        }
        UserID newUserID = UserIDGeneratorSingleton.getInstance().getNextID();
        loginService.saveNewUser(username, newUserID);
        return newUserID;
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
