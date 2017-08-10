package com.beleco.gameofwar.rest.domain.game;

/**
 * Created by Everdark on 04.07.2017.
 */
public class UserID {
    private String userID;

    public UserID(String userID){
        this.userID=userID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
