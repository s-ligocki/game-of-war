package com.beleco.gameofwar.service;

import com.beleco.gameofwar.domain.game.Board;
import com.beleco.gameofwar.domain.game.Dot;
import com.beleco.gameofwar.domain.game.GameState;
import com.beleco.gameofwar.exception.NotValidBoardExcepiton;
import com.beleco.gameofwar.exception.NotValidUserIdException;
import com.beleco.gameofwar.exception.NotValidUsernameException;
import com.beleco.gameofwar.util.EnumRandomizer;
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
    EnumRandomizer<GameState> gameStateRandomizer;

    @Override
    public String login(String username) throws NotValidUsernameException {
        if(username==null){
            throw new NotValidUsernameException("Username is null");
        }
        return "NEW_USER_ID_0000000";
    }

    @Override
    public void reset(String userId) throws NotValidUserIdException {
        if(userId==null){
            throw new NotValidUserIdException("UserID is null");
        }
    }

    @Override
    public Board getBoardState(String userId) throws NotValidUserIdException{
        if(userId==null){
            throw new NotValidUserIdException("UserId is null");
        }
        return createRandomBoard();
    }

    @Override
    public GameState getGameState(String userId) throws NotValidUserIdException {
        return gameStateRandomizer.getRandomValue();
    }

    @Override
    public void play(Board board) throws NotValidBoardExcepiton {
        if(board==null){
            throw new NotValidBoardExcepiton("Board is corrupted");
        }
    }

    private Board createRandomBoard(){
        Board mockBoard = new Board();
        fillBoardFields(mockBoard);
        return mockBoard;
    }

    private void fillBoardFields(Board board){
        board.setOwnerId(OWNER_ID);
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
