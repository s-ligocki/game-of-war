package com.beleco.gameofwar.core.domain;

/**
 * Created by Everdark on 13.06.2017.
 */
public enum Dot {
    EMPTY, PLAYER_ONE, PLAYER_TWO;

    @Override
    public String toString(){return this.name();}
}
