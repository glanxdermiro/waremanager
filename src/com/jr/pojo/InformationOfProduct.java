package com.jr.pojo;


public class InformationOfProduct {//创建一个容器类，接收产品及其库存仓库信息，以便于便利查询
    public int nProId;
    public String nProName;
    public String nDate;
    public String nDeadDate;
    public int nProductSum;
    public int nSID;
    public String nType;
    public String nName;

    public int getnProId() {
        return nProId;
    }

    public void setnProId(int nProId) {
        this.nProId = nProId;
    }

    public String getnProName() {
        return nProName;
    }

    public void setnProName(String nProName) {
        this.nProName = nProName;
    }

    public String getnDate() {
        return nDate;
    }

    public void setnDate(String nDate) {
        this.nDate = nDate;
    }

    public String getnDeadDate() {
        return nDeadDate;
    }

    public void setnDeadDate(String nDeadDate) {
        this.nDeadDate = nDeadDate;
    }

    public int getnProductSum() {
        return nProductSum;
    }

    public void setnProductSum(int nProductSum) {
        this.nProductSum = nProductSum;
    }

    public int getnSID() {
        return nSID;
    }

    public void setnSID(int nSID) {
        this.nSID = nSID;
    }

    public String getnType() {
        return nType;
    }

    public void setnType(String nType) {
        this.nType = nType;
    }

    public String getnName() {
        return nName;
    }

    public void setnName(String nName) {
        this.nName = nName;
    }

    @Override
    public String toString() {
        return "informationOfProduct{" +
                "nProId=" + nProId +
                ", nProName='" + nProName + '\'' +
                ", nDate='" + nDate + '\'' +
                ", nDeadDate='" + nDeadDate + '\'' +
                ", nProductSum=" + nProductSum +
                ", nSID=" + nSID +
                ", nType='" + nType + '\'' +
                ", nName='" + nName + '\'' +
                '}';
    }
}
