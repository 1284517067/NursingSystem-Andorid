package com.example.nursingsystem.Model;

import java.io.Serializable;

public class Dietary_Form implements Serializable {
    private int inpatient;//住院号
    private long eat_list;//膳食单号
    private int bed_num;//床号
    private String name;//姓名
    private String eat_type;//膳食类别
    private String liuquidity;//时间（一天几次）
    private int job_num;//工号
    private String state;//状态

    public Dietary_Form() {
    }

    public int getInpatient() {
        return inpatient;
    }

    public void setInpatient(int inpatient) {
        this.inpatient = inpatient;
    }

    public long getEat_list() {
        return eat_list;
    }

    public void setEat_list(long eat_list) {
        this.eat_list = eat_list;
    }

    public int getBed_num() {
        return bed_num;
    }

    public void setBed_num(int bed_num) {
        this.bed_num = bed_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEat_type() {
        return eat_type;
    }

    public void setEat_type(String eat_type) {
        this.eat_type = eat_type;
    }

    public String getLiuquidity() {
        return liuquidity;
    }

    public void setLiuquidity(String liuquidity) {
        this.liuquidity = liuquidity;
    }

    public int getJob_num() {
        return job_num;
    }

    public void setJob_num(int job_num) {
        this.job_num = job_num;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
