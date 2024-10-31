package com.jr.pojo;



public class Product {
    private Integer pID;
    private String pno;
    private String pName;
    private String pType;
    private String pDate;
    private String pDeadDate;

    public Product() {
    }

    public Product(Integer pID, String pno, String pName, String pType, String pDate, String pDeadDate) {
        this.pID = pID;
        this.pno = pno;
        this.pName = pName;
        this.pType = pType;
        this.pDate = pDate;
        this.pDeadDate = pDeadDate;
    }

    public Integer getpID() {
        return pID;
    }

    public void setpID(Integer pID) {
        this.pID = pID;
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType;
    }

    public String getpDate() {
        return pDate;
    }

    public void setpDate(String pDate) {
        this.pDate = pDate;
    }

    public String getpDeadDate() {
        return pDeadDate;
    }

    public void setpDeadDate(String pDeadDate) {
        this.pDeadDate = pDeadDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pID=" + pID +
                ", pno=" + pno +
                ", pName='" + pName + '\'' +
                ", pType='" + pType + '\'' +
                ", pDate='" + pDate + '\'' +
                ", pDeadDate='" + pDeadDate + '\'' +
                '}';
    }
}
