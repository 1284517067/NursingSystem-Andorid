package com.example.nursingsystem.Model;

import java.io.Serializable;

public class SickBed implements Serializable {
    private String department;//科室
    private String name;//姓名
    private String sex;//性别
    private int age;//年龄
    private int inpatient;//住院号
    private int bed_num;//床位号
    private String diagnosis;//诊断
    private double already_paid;//已付款信息
    private double prepayments;//预付款信息
    private double total;//总金额
    private String carelevel;//护理等级

    public SickBed() {
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public double getAlready_paid() {
        return already_paid;
    }

    public void setAlready_paid(double already_paid) {
        this.already_paid = already_paid;
    }

    public double getPrepayments() {
        return prepayments;
    }

    public void setPrepayments(double prepayments) {
        this.prepayments = prepayments;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCarelevel() {
        return carelevel;
    }

    public void setCarelevel(String carelevel) {
        this.carelevel = carelevel;
    }
}
