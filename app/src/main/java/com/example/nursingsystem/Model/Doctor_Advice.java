package com.example.nursingsystem.Model;

import java.io.Serializable;
import java.util.Date;

public class Doctor_Advice implements Serializable {
    private String name;//病人姓名
    private long inpatient;//住院号
    private String doc_order_content;//医嘱内容
    private String order_type;//医嘱类别
    private Date entry_time;//录入时间
    private String status;//医嘱状态

    public Doctor_Advice() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getInpatient() {
        return inpatient;
    }

    public void setInpatient(long inpatient) {
        this.inpatient = inpatient;
    }

    public String getDoc_order_content() {
        return doc_order_content;
    }

    public void setDoc_order_content(String doc_order_content) {
        this.doc_order_content = doc_order_content;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public Date getEntry_time() {
        return entry_time;
    }

    public void setEntry_time(Date entry_time) {
        this.entry_time = entry_time;
    }
}
