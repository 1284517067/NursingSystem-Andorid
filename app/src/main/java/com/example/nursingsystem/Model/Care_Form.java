package com.example.nursingsystem.Model;

import java.io.Serializable;

public class Care_Form implements Serializable {
    private String name;//姓名
    private int inpatient;//住院号
    private long care_list;//护理单号
    private String content;//内容
    private String caretype;//护理级别
    private int job_num;//工号

    public Care_Form() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInpatient() {
        return inpatient;
    }

    public void setInpatient(int inpatient) {
        this.inpatient = inpatient;
    }

    public long getCare_list() {
        return care_list;
    }

    public void setCare_list(long care_list) {
        this.care_list = care_list;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCaretype() {
        return caretype;
    }

    public void setCaretype(String caretype) {
        this.caretype = caretype;
    }

    public int getJob_num() {
        return job_num;
    }

    public void setJob_num(int job_num) {
        this.job_num = job_num;
    }
}
