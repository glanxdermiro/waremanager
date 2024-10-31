package com.jr.pojo;

public class P_stock {
    private Integer psID;
    private Integer pID;
    private Integer sID;
    private String inputDate;
    private Integer productSum;

    public P_stock() {
    }

    public P_stock(Integer psID, Integer pID, Integer sID, String inputDate, Integer productSum) {
        this.psID = psID;
        this.pID = pID;
        this.sID = sID;
        this.inputDate = inputDate;
        this.productSum = productSum;
    }

    public Integer getPsID() {
        return psID;
    }

    public void setPsID(Integer psID) {
        this.psID = psID;
    }

    public Integer getpID() {
        return pID;
    }

    public void setpID(Integer pID) {
        this.pID = pID;
    }

    public Integer getsID() {
        return sID;
    }

    public void setsID(Integer sID) {
        this.sID = sID;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public Integer getProductSum() {
        return productSum;
    }

    public void setProductNum(Integer productSum) {
        this.productSum = productSum;
    }

    @Override
    public String toString() {
        return "P_stock{" +
                "psID=" + psID +
                ", pID=" + pID +
                ", sID=" + sID +
                ", inputDate='" + inputDate + '\'' +
                ", productSum=" + productSum +
                '}';
    }
}
