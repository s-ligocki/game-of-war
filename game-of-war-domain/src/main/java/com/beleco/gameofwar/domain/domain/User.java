package com.beleco.gameofwar.domain.domain;

/**
 * Created by Everdark on 20.08.2017.
 */
public class User {
    private UserID userID;
    private String username;

    public User(UserID userID, String username){
        this.userID = userID;
        this.username = username;
    }

    public UserID getUserID() {
        return userID;
    }

    public void setUserID(UserID userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        username = username;
    }
}
