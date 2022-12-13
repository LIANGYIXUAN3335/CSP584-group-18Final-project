package com.iit.bean;

import java.io.Serializable;

public class Near implements Serializable {
    private String name;
    private String address;
    private boolean open;
    private int distance;
    private long phoneNo;
    public Near(String name,String address,boolean open,int distance, long phoneNo){
        this.name = name;
        this.address = address;
        this.open = open;
        this.distance= distance;
        this.phoneNo = phoneNo;
    }
    public Near(String name,String address){
        this.name = name;
        this.address =address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return open;
    }

    public int getDistance() {
        return distance;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

}
