package com.example.nursingsystem.Model;

import java.io.Serializable;
import java.util.Date;

public class Tranfusion_Form implements Serializable {
    private long id;//输液单号
    private int inpatient;//住院号
    private int bed_num;//床号
    private String name;//姓名
    private String drug_name;//药品名
    private Date time;//起始时间
    private int job_num;//工号
    private String state;//执行状态

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Tranfusion_Form() {
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

    public String getDrug_name() {
        return drug_name;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
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
