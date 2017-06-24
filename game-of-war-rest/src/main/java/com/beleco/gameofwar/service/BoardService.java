package com.beleco.gameofwar.service;

import com.beleco.gameofwar.domain.game.Board;
import com.beleco.gameofwar.exception.NotValidBoardExcepiton;

/**
 * Created by Everdark on 13.06.2017.
 */
public interface BoardService {
    Board getNewGeneration(Board currentState) throws NotValidBoardExcepiton;
}
