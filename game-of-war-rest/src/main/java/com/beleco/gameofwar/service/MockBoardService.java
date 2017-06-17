package com.beleco.gameofwar.service;

import com.beleco.gameofwar.domain.game.Board;
import com.beleco.gameofwar.domain.game.Dot;
import com.beleco.gameofwar.domain.game.TriStateLife;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by Everdark on 13.06.2017.
 */
@Component
public class MockBoardService implements BoardService{

    @Override
    public Board getNewGeneration(Board currentState) {

        Board mockBoard = new Board();
        mockBoard.setOwnerId(Long.valueOf(0));
        mockBoard.setSize(3);

        Dot[][] state = new Dot[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++) {
                Random generator = new Random();
                state[i][j] = new Dot(TriStateLife.valueOfInt(generator.nextInt(3)));
            }
        }
        mockBoard.setState(state);

        return mockBoard;
    }
}
