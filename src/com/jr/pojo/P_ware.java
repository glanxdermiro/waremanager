package com.jr.pojo;

public class P_ware {
    private Integer pwID;
    private Integer pID;
    private Integer wID;

    public P_ware() {
    }

    public P_ware(Integer pwID, Integer pID, Integer wID) {
        this.pwID = pwID;
        this.pID = pID;
        this.wID = wID;
    }

    public Integer getPwID() {
        return pwID;
    }

    public void setPwID(Integer pwID) {
        this.pwID = pwID;
    }

    public Integer getpID() {
        return pID;
    }

    public void setpID(Integer pID) {
        this.pID = pID;
    }

    public Integer getwID() {
        return wID;
    }

    public void setwID(Integer wID) {
        this.wID = wID;
    }

    @Override
    public String toString() {
        return "P_ware{" +
                "pwID=" + pwID +
                ", pwpID=" + pID +
                ", pwwID=" + wID +
                '}';
    }
}
