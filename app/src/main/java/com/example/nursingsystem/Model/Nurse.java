package com.example.nursingsystem.Model;

import java.io.Serializable;
import java.util.Date;

public class Nurse implements Serializable {
    private int job_num;//工号
    private String password;//密码
    private String department;//科室
    private String name;//姓名
    private String sex;//性别
    private Date birth;//生日
    private String political_status;//政治面貌
    private String nation;//民族
    private String marital_status;//婚姻状况
    private String job_title;//职称
    private Date admission_time;//入科工作时间
    private String education;//学历
    private String graduated;//毕业院校
    private String blood;//血型
    private String tel;//电话号码
    private String email;//邮箱

    public Nurse() {
    }

    public int getJob_num() {
        return job_num;
    }

    public void setJob_num(int job_num) {
        this.job_num = job_num;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPolitical_status() {
        return political_status;
    }

    public void setPolitical_status(String political_status) {
        this.political_status = political_status;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public Date getAdmission_time() {
        return admission_time;
    }

    public void setAdmission_time(Date admission_time) {
        this.admission_time = admission_time;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getGraduated() {
        return graduated;
    }

    public void setGraduated(String graduated) {
        this.graduated = graduated;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
