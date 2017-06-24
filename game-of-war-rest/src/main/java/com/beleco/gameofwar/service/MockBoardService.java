package com.beleco.gameofwar.service;

import com.beleco.gameofwar.domain.game.Board;
import com.beleco.gameofwar.domain.game.Dot;
import com.beleco.gameofwar.exception.NotValidBoardExcepiton;
import com.beleco.gameofwar.util.EnumRandomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Everdark on 13.06.2017.
 */
@Component
public class MockBoardService implements BoardService{

    private final long OWNER_ID = 0L;
    private final int BOARD_SIZE = 3;

    @Autowired
    EnumRandomizer<Dot> randomizer;

    @Override
    public Board getNewGeneration(Board currentState) throws NotValidBoardExcepiton{
        if(currentState==null){
            throw new NotValidBoardExcepiton("Board is not initialized");
        }
        return createRandomBoard();
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
                state[i][j] = randomizer.getRandomValue();
            }
        }
    }
}
