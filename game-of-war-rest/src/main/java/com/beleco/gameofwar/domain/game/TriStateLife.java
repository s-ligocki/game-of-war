package com.beleco.gameofwar.domain.game;

/**
 * Created by Everdark on 13.06.2017.
 */
public enum TriStateLife {
    EMPTY, BLACK, WHITE;

    public String toString(){return this.name();}

    public static TriStateLife valueOfInt(int intValue){
        if(intValue==0)
            return EMPTY;
        else if(intValue==1)
            return BLACK;
        else
            return WHITE;
    }
}
