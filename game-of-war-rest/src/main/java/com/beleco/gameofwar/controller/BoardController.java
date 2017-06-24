package com.beleco.gameofwar.controller;

import com.beleco.gameofwar.domain.game.Board;
import com.beleco.gameofwar.exception.NotValidBoardExcepiton;
import com.beleco.gameofwar.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Everdark on 13.06.2017.
 */
@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;

    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping(value = "/get-new-board", method = RequestMethod.GET)
    public Board getInitialBoard() throws NotValidBoardExcepiton {
        return boardService.getNewGeneration(null);
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping(value = "/get-new-generation", method = RequestMethod.POST)
    public Board getNextBoard(@RequestBody Board board) throws NotValidBoardExcepiton {
        return boardService.getNewGeneration(board);
    }
}
