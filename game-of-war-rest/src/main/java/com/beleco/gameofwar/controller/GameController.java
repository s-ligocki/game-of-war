package com.beleco.gameofwar.controller;

import com.beleco.gameofwar.domain.game.Board;
import com.beleco.gameofwar.domain.game.GameState;
import com.beleco.gameofwar.exception.NotValidBoardExcepiton;
import com.beleco.gameofwar.exception.NotValidUsernameException;
import com.beleco.gameofwar.exception.NotValidUserIdException;
import com.beleco.gameofwar.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Everdark on 13.06.2017.
 */
@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    /**
     * @return [unique] userId
     */
    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping(value = "/login/{username}", method = RequestMethod.GET)
    public String login(@PathVariable String username) throws NotValidUsernameException {
        return gameService.login(username);
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping(value = "/reset/{userId}", method = RequestMethod.GET)
    public void reset(@PathVariable String userId) throws NotValidUserIdException {
        gameService.reset(userId);
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping(value = "/get-game-state/{userId}", method = RequestMethod.GET)
    public GameState getGameState(@PathVariable String userId) throws NotValidUserIdException {
        return gameService.getGameState(userId);
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping(value = "/get-board/{userId}", method = RequestMethod.GET)
    public Board getBoard(@PathVariable String userId) throws NotValidUserIdException {
        return gameService.getBoardState(userId);
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping(value = "/play", method = RequestMethod.POST)
    public void play(@RequestBody Board board) throws NotValidBoardExcepiton {
        gameService.play(board);
    }
}
