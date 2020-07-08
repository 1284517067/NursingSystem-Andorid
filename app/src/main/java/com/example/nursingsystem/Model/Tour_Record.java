package com.example.nursingsystem.Model;

import java.io.Serializable;

public class Tour_Record implements Serializable {
    private String inspection_situation;//巡视情况
    private long id;//巡视记录单号
    private long inpatient;//住院号
    private String time;//巡视时间
    private int job_num;//工号

    public String getInspection_situation() {
        return inspection_situation;
    }

    public void setInspection_situation(String inspection_situation) {
        this.inspection_situation = inspection_situation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getInpatient() {
        return inpatient;
    }

    public void setInpatient(long inpatient) {
        this.inpatient = inpatient;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getJob_num() {
        return job_num;
    }

    public void setJob_num(int job_num) {
        this.job_num = job_num;
    }

    public Tour_Record() {
    }
}
