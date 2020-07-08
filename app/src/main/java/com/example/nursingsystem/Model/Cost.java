package com.example.nursingsystem.Model;

import java.io.Serializable;

public class Cost implements Serializable {
    private long id;//费用单号
    private int inpatient;//住院号
    private String content;//收费内容
    private double already_paid;//已付款
    private double unpaid;//未付款

    public Cost() {
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

    public double getAlready_paid() {
        return already_paid;
    }

    public void setAlready_paid(double already_paid) {
        this.already_paid = already_paid;
    }

    public double getUnpaid() {
        return unpaid;
    }

    public void setUnpaid(double unpaid) {
        this.unpaid = unpaid;
    }
}
