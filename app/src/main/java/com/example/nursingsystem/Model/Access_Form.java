package com.example.nursingsystem.Model;

import java.io.Serializable;
import java.util.Date;

public class Access_Form implements Serializable {
    private long id;//出入登记单号
    private int inpatient;//住院号
    private String name;//姓名
    private Date out;//外出时间
    private Date back;//回室时间
    private String reason;//外出原因
    private String nurse_name;//经管护士
    private int job_num;//工号
    private String status;//出入状态


    public Access_Form() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getInpatient() {
        return inpatient;
    }

    public void setInpatient(int inpatient) {
        this.inpatient = inpatient;
    }

    public long getId() {
        return id;
    }

    public String getNurse_name() {
        return nurse_name;
    }

    public void setNurse_name(String nurse_name) {
        this.nurse_name = nurse_name;
    }

    public int getJob_num() {
        return job_num;
    }

    public void setJob_num(int job_num) {
        this.job_num = job_num;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getOut() {
        return out;
    }

    public void setOut(Date out) {
        this.out = out;
    }

    public Date getBack() {
        return back;
    }

    public void setBack(Date back) {
        this.back = back;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
