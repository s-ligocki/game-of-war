package com.beleco.gameofwar.domain.game;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by Everdark on 13.06.2017.
 */
public class Dot {

    private Board board;

    private TriStateLife stateOfLife;

    public Dot(TriStateLife stateOfLife){
        this.stateOfLife = stateOfLife;
    }

    public Dot(){
        this(TriStateLife.EMPTY);
    }

    public TriStateLife getStateOfLife() {
        return stateOfLife;
    }

    public void setStateOfLife(TriStateLife stateOfLife) {
        this.stateOfLife = stateOfLife;
    }
}
