package com.example.nursingsystem.Model;

import java.io.Serializable;
import java.util.Date;

public class Nursing_Sheet implements Serializable {
    private long id;//护理单号
    private int inpatient;//住院号
    private Date date;//日期
    private double oxygen;//吸氧
    private double input;//入量
    private double output;//出量
    private String skin;//皮肤情况
    private String tube_care;//管路护理
    private String observation;//病情观察及措施
    private int job_num;//工号

    public Nursing_Sheet() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getOxygen() {
        return oxygen;
    }

    public void setOxygen(double oxygen) {
        this.oxygen = oxygen;
    }

    public double getInput() {
        return input;
    }

    public void setInput(double input) {
        this.input = input;
    }

    public double getOutput() {
        return output;
    }

    public void setOutput(double output) {
        this.output = output;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getTube_care() {
        return tube_care;
    }

    public void setTube_care(String tube_care) {
        this.tube_care = tube_care;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public int getJob_num() {
        return job_num;
    }

    public void setJob_num(int job_num) {
        this.job_num = job_num;
    }
}
