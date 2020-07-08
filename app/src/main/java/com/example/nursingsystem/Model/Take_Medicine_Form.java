package com.example.nursingsystem.Model;

import java.io.Serializable;
import java.util.Date;

public class Take_Medicine_Form implements Serializable {
    private long id;//服药单号
    private int inpatient;//住院号
    private int bed_num;//床号
    private String name;//姓名
    private String elixir;//药剂
    private Date time;//服药时间
    private int job_num;//工号
    private String state;//状态

    public Take_Medicine_Form() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getInpatient() {
        return inpatient;
    }

    public void setInpatient(int inpatient) {
        this.inpatient = inpatient;
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

    public String getElixir() {
        return elixir;
    }

    public void setElixir(String elixir) {
        this.elixir = elixir;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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
