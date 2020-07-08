package com.example.nursingsystem.Model;

import java.io.Serializable;

public class Nurse_Attentance_Sheet implements Serializable {
    private int id;//考勤表号
    private int job_num;//工号
    private String on;//上班打卡时间
    private String off;//下班打卡时间
    private String note;//备注

    public Nurse_Attentance_Sheet() {
    }

    public int getJob_num() {
        return job_num;
    }

    public void setJob_num(int job_num) {
        this.job_num = job_num;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOn() {
        return on;
    }

    public void setOn(String on) {
        this.on = on;
    }

    public String getOff() {
        return off;
    }

    public void setOff(String off) {
        this.off = off;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
