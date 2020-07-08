package com.example.nursingsystem.Model;

import java.io.Serializable;
import java.util.Date;

public class Employee_Schedule implements Serializable {
    private long job_list;//排班单
    private String content;//内容
    private Date day;//日期

    public Employee_Schedule() {
    }


    public long getJob_list() {
        return job_list;
    }

    public void setJob_list(long job_list) {
        this.job_list = job_list;
    }


    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }
}
