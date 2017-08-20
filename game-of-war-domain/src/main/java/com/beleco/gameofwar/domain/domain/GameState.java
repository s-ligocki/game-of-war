package com.beleco.gameofwar.domain.domain;

/**
 * Created by Everdark on 04.07.2017.
 */
public class GameState{

    private GameStateEnumerable gameState;

    public GameState(GameStateEnumerable gameState){
        this.gameState=gameState;
    }

    public GameStateEnumerable getGameState() {
        return gameState;
    }

    public void setGameState(GameStateEnumerable gameState) {
        this.gameState = gameState;
    }

    public enum GameStateEnumerable {
        WAITING_FOR_OPPONENT, YOUR_TURN, OPPONENTS_TURN;

        @Override
        public String toString(){return this.name();}
    }
}

