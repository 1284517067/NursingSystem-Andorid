package com.example.nursingsystem.Model;

import java.io.Serializable;

public class WorkLoad implements Serializable {
    private int job_num;//工号
    private int workload;//治疗类工作量统计
    private int careload;//护理类工作量统计
    private double totaltime;//工作总时长

    public WorkLoad() {
    }

    public int getJob_num() {
        return job_num;
    }

    public void setJob_num(int job_num) {
        this.job_num = job_num;
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

    public int getCareload() {
        return careload;
    }

    public void setCareload(int careload) {
        this.careload = careload;
    }

    public double getTotaltime() {
        return totaltime;
    }

    public void setTotaltime(double totaltime) {
        this.totaltime = totaltime;
    }
}
