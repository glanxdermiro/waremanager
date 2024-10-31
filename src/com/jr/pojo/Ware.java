package com.jr.pojo;

public class Ware {
    private Integer wID;
    private String wno;
    private String wName;
    private Integer wV;
    private String wAddress;

    public Ware() {
    }

    public Ware(Integer wID, String wno, String wName, Integer wV, String wAddress) {
        this.wID = wID;
        this.wno = wno;
        this.wName = wName;
        this.wV = wV;
        this.wAddress = wAddress;
    }

    public Integer getwID() {
        return wID;
    }

    public void setwID(Integer wID) {
        this.wID = wID;
    }

    public String getWno() {
        return wno;
    }

    public void setWno(String wno) {
        this.wno = wno;
    }

    public String getwName() {
        return wName;
    }

    public void setwName(String wName) {
        this.wName = wName;
    }

    public Integer getwV() {
        return wV;
    }

    public void setwV(Integer wV) {
        this.wV = wV;
    }

    public String getwAddress() {
        return wAddress;
    }

    public void setwAddress(String wAddress) {
        this.wAddress = wAddress;
    }

    @Override
    public String toString() {
        return "Ware{" +
                "wID=" + wID +
                ", wno=" + wno +
                ", wName='" + wName + '\'' +
                ", wV=" + wV +
                ", wAddress='" + wAddress + '\'' +
                '}';
    }
}
