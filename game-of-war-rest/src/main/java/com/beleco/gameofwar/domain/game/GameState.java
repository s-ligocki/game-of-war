package com.beleco.gameofwar.domain.game;

/**
 * Created by Everdark on 04.07.2017.
 */
public enum GameState {
    WAITING_FOR_OPPONENT, YOUR_TURN, OPPONENTS_TURN;

    @Override
    public String toString(){return this.name();}
}
