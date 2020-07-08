package com.example.nursingsystem.Model;

import java.io.Serializable;
import java.util.Date;

public class Treatment_Recipe implements Serializable {
    private int inpartient;//住院号
    private long treatment_list;//治疗单号
    private int bed_num;//病床号
    private Date day;//开单日期
    private String executive;//执行科室
    private String billing;//开单科室
    private String visiting;//就诊科室
    private String name;//姓名
    private String sex;//性别
    private int age;//年龄
    private String clinical_diagnosis;//临床诊断
    private double treatment;//治疗费

    public Treatment_Recipe() {
    }

    public int getInpartient() {
        return inpartient;
    }

    public void setInpartient(int inpartient) {
        this.inpartient = inpartient;
    }

    public long getTreatment_list() {
        return treatment_list;
    }

    public void setTreatment_list(long treatment_list) {
        this.treatment_list = treatment_list;
    }

    public int getBed_num() {
        return bed_num;
    }

    public void setBed_num(int bed_num) {
        this.bed_num = bed_num;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getExecutive() {
        return executive;
    }

    public void setExecutive(String executive) {
        this.executive = executive;
    }

    public String getBilling() {
        return billing;
    }

    public void setBilling(String billing) {
        this.billing = billing;
    }

    public String getVisiting() {
        return visiting;
    }

    public void setVisiting(String visiting) {
        this.visiting = visiting;
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

    public String getClinical_diagnosis() {
        return clinical_diagnosis;
    }

    public void setClinical_diagnosis(String clinical_diagnosis) {
        this.clinical_diagnosis = clinical_diagnosis;
    }

    public double getTreatment() {
        return treatment;
    }

    public void setTreatment(double treatment) {
        this.treatment = treatment;
    }
}
