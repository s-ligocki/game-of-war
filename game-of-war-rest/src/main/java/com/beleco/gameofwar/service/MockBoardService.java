package com.beleco.gameofwar.service;

import com.beleco.gameofwar.domain.game.Board;
import com.beleco.gameofwar.domain.game.TriStateLife;
import com.beleco.gameofwar.util.EnumRandomizer;
import org.springframework.stereotype.Component;

/**
 * Created by Everdark on 13.06.2017.
 */
@Component
public class MockBoardService implements BoardService{

    @Override
    public Board getNewGeneration(Board currentState) {

        Board mockBoard = new Board();
        mockBoard.setOwnerId(0L);
        mockBoard.setSize(3);

        TriStateLife[][] state = new TriStateLife[3][3];
        EnumRandomizer<TriStateLife> generator = new EnumRandomizer(TriStateLife.class);
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++) {
                state[i][j] = generator.getRandomValue();
            }
        }
        mockBoard.setState(state);

        return mockBoard;
    }
}
