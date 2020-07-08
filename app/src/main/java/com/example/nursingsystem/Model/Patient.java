package com.example.nursingsystem.Model;

import java.io.Serializable;

public class Patient implements Serializable {
    private String name;//姓名
    private String id;//身份证号
    private String sex;//性别
    private int age;//年龄
    private int bed_num;//病床号
    private int inpatient;//住院号
    private String department;//科室
    private String address;//住址
    private String hometown;//籍贯
    private String nation;//民族
    private String admission_date;//入院日期
    private String duscgarge_date;//出院日期
    private String status;//状态

    public Patient() {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBed_num() {
        return bed_num;
    }

    public void setBed_num(int bed_num) {
        this.bed_num = bed_num;
    }

    public int getInpatient() {
        return inpatient;
    }

    public void setInpatient(int inpatient) {
        this.inpatient = inpatient;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getAdmission_date() {
        return admission_date;
    }

    public void setAdmission_date(String admission_date) {
        this.admission_date = admission_date;
    }

    public String getDuscgarge_date() {
        return duscgarge_date;
    }

    public void setDuscgarge_date(String duscgarge_date) {
        this.duscgarge_date = duscgarge_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
