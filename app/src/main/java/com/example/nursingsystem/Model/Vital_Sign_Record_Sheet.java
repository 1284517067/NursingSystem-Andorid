package com.example.nursingsystem.Model;

import java.io.Serializable;
import java.util.Date;

public class Vital_Sign_Record_Sheet implements Serializable {
    private long id;//生命体征记录单号
    private double height;//身高
    private double weight;//体重
    private String datetime;//日期时间
    private double temperature;//体温
    private double pluse;//脉搏次/分
    private int breathe;//呼吸次/分
    private double blood_oxygen;//血氧饱和度
    private int blood_pressure;//血压
    private double blood_sugar;//血糖
    private int job_num;//工号
    private int inpartient;//住院号

    public Vital_Sign_Record_Sheet() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPluse() {
        return pluse;
    }

    public void setPluse(double pluse) {
        this.pluse = pluse;
    }

    public int getBreathe() {
        return breathe;
    }

    public void setBreathe(int breathe) {
        this.breathe = breathe;
    }

    public int getBlood_pressure() {
        return blood_pressure;
    }

    public void setBlood_pressure(int blood_pressure) {
        this.blood_pressure = blood_pressure;
    }

    public double getBlood_sugar() {
        return blood_sugar;
    }

    public void setBlood_sugar(double blood_sugar) {
        this.blood_sugar = blood_sugar;
    }

    public int getJob_num() {
        return job_num;
    }

    public void setJob_num(int job_num) {
        this.job_num = job_num;
    }

    public double getBlood_oxygen() {
        return blood_oxygen;
    }

    public void setBlood_oxygen(double blood_oxygen) {
        this.blood_oxygen = blood_oxygen;
    }

    public int getInpartient() {
        return inpartient;
    }

    public void setInpartient(int inpartient) {
        this.inpartient = inpartient;
    }
}
