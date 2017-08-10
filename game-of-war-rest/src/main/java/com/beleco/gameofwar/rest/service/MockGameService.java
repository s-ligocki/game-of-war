package com.beleco.gameofwar.rest.service;

import com.beleco.gameofwar.core.domain.Board;
import com.beleco.gameofwar.core.domain.Dot;
import com.beleco.gameofwar.core.domain.GameState;
import com.beleco.gameofwar.core.domain.UserID;
import com.beleco.gameofwar.core.exception.GameException;
import com.beleco.gameofwar.rest.exception.NotValidBoardExcepiton;
import com.beleco.gameofwar.rest.exception.NotValidUserIdException;
import com.beleco.gameofwar.rest.exception.NotValidUsernameException;
import com.beleco.gameofwar.rest.util.EnumRandomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Everdark on 13.06.2017.
 */
@Component
public class MockGameService implements GameService {

    private final long OWNER_ID = 0L;
    private final int BOARD_SIZE = 3;

    @Autowired
    EnumRandomizer<Dot> dotRandomizer;

    @Autowired
    EnumRandomizer<GameState.GameStateEnumerable> gameStateRandomizer;

    @Override
    public UserID login(String username) throws NotValidUsernameException {
        if(username.equals("_")){
            throw new NotValidUsernameException("Username is null");
        }
        return new UserID("NEW_USER_ID_0000000_" + username);
    }

    @Override
    public void reset(String userId) throws NotValidUserIdException {
        if(userId.equals("_")){
            throw new NotValidUserIdException("UserID is null");
        }
    }

    @Override
    public Board getBoardState(String userId) throws NotValidUserIdException{
        if(userId.equals("_")){
            throw new NotValidUserIdException("UserId is null");
        }
        return createRandomBoard();
    }

    @Override
    public GameState getGameState(String userId) throws NotValidUserIdException {
        return new GameState(gameStateRandomizer.getRandomValue());
    }

    @Override
    public void play(Board board, String userId) throws GameException {
        if(board==null){
            throw new NotValidBoardExcepiton("Board is corrupted");
        }else if(userId.equals("_")){
            throw new NotValidUserIdException("UserId is null");
        }
    }

    private Board createRandomBoard(){
        Board mockBoard = new Board();
        fillBoardFields(mockBoard);
        return mockBoard;
    }

    private void fillBoardFields(Board board){
        board.setSize(BOARD_SIZE);
        board.setState(createBoardState(BOARD_SIZE));
    }

    private Dot[][] createBoardState(int boardSize){
        Dot[][] state = new Dot[boardSize][boardSize];
        randomizeBoardState(state);
        return state;
    }

    private void randomizeBoardState(Dot[][] state){
        for(int i=0; i<state.length; i++){
            for(int j=0; j<state[i].length; j++) {
                state[i][j] = dotRandomizer.getRandomValue();
            }
        }
    }
}
