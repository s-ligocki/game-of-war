package com.beleco.gameofwar.core.domain;

/**
 * Created by Everdark on 19.08.2017.
 */
public class ReturnStatus {
    private String isOk;

    public ReturnStatus(String isOk){
        this.isOk = isOk;
    }

    public String getIsOk() {
        return isOk;
    }

    public void setIsOk(String isOk) {
        this.isOk = isOk;
    }
}
