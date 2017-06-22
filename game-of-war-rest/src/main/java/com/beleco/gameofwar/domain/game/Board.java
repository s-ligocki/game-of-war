package com.beleco.gameofwar.domain.game;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Created by Everdark on 13.06.2017.
 */
public class Board {

    private TriStateLife[][] state;
    private int size;
    private Long ownerId;

    public TriStateLife[][] getState() {
        return state;
    }

    public void setState(TriStateLife[][] state) {
        this.state = state;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
