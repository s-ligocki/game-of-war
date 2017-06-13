package com.beleco.gameofwar.component;

import com.beleco.gameofwar.domain.game.Board;
import com.beleco.gameofwar.service.BoardService;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Everdark on 13.06.2017.
 */
@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping(value = "/get-new-generation", method = RequestMethod.GET)
    public Board getNextBoard() {
        return boardService.getNewGeneration(null);
    }
}
