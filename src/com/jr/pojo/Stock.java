package com.jr.pojo;

public class Stock {
    private Integer sID;
    private Integer wID;
    private Integer sV;
    private Integer sVed;
    private Integer sVwarn;
    private String sType;

    public Stock() {
    }

    public Stock(Integer sID, Integer wID, Integer sV, Integer sVed, Integer sVwarn, String sType) {
        this.sID = sID;
        this.wID = wID;
        this.sV = sV;
        this.sVed = sVed;
        this.sVwarn = sVwarn;
        this.sType = sType;
    }

    public Integer getsID() {
        return sID;
    }

    public void setsID(Integer sID) {
        this.sID = sID;
    }

    public Integer getwID() {
        return wID;
    }

    public void setwID(Integer wID) {
        this.wID = wID;
    }

    public Integer getsV() {
        return sV;
    }

    public void setsV(Integer sV) {
        this.sV = sV;
    }

    public Integer getsVed() {
        return sVed;
    }

    public void setsVed(Integer sVed) {
        this.sVed = sVed;
    }

    public Integer getsVwarn() {
        return sVwarn;
    }

    public void setsVwarn(Integer sVwarn) {
        this.sVwarn = sVwarn;
    }

    public String getsType() {
        return sType;
    }

    public void setsType(String sType) {
        this.sType = sType;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "sID=" + sID +
                ", swID=" + wID +
                ", sV=" + sV +
                ", sVed=" + sVed +
                ", sVwarn=" + sVwarn +
                ", sType='" + sType + '\'' +
                '}';
    }
}
