package com.organOld.dao.entity;

public class Coordinate extends DBEntity{
    private int Id;
    private String cx;
    private String cy;
    private Integer taskid;
    private String name;
    private String qq;
    private String phone;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getcx() {
        return cx;
    }

    public void setcx(String cx) {
        this.cx = cx;
    }

    public String getcy() {
        return cy;
    }

    public void setcy(String cy) {
        this.cy = cy;
    }

    public Integer gettaskid() {
        return taskid;
    }

    public void settaskid(Integer taskid) {
        this.taskid = taskid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
