package com.example.nursingsystem.Presenter;

import com.example.nursingsystem.Model.Doctor_Advice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Doctor_AdvicePresenter {
    public List<Doctor_Advice> initDoctorAdvice(long inpatient){
        List<Doctor_Advice>list = new ArrayList<>();
        /**
         * 测试用假数据
         */
        Doctor_Advice doctor_advice = new Doctor_Advice();
        doctor_advice.setName("萨霍案");
        doctor_advice.setOrder_type("临时医嘱");
        doctor_advice.setDoc_order_content("5%葡萄糖溶液");
        doctor_advice.setEntry_time(new Date());
        doctor_advice.setInpatient(141455);
        doctor_advice.setStatus("未核查");
        for (int i = 0 ; i < 10;i++){
            list.add(doctor_advice);
        }
        return list;
    }

    public List<Doctor_Advice> initAllDoctorAdvice(){
        List<Doctor_Advice>list = new ArrayList<>();
        /**
         * 测试用假数据
         */
        Doctor_Advice doctor_advice = new Doctor_Advice();
        doctor_advice.setName("萨霍案");
        doctor_advice.setOrder_type("临时医嘱");
        doctor_advice.setDoc_order_content("5%葡萄糖溶液");
        doctor_advice.setEntry_time(new Date());
        doctor_advice.setInpatient(141455);
        Doctor_Advice doctor_advice1 = new Doctor_Advice();
        doctor_advice1.setName("啊哦哦");
        doctor_advice1.setOrder_type("临时医嘱");
        doctor_advice1.setDoc_order_content("生理盐水");
        doctor_advice1.setEntry_time(new Date());
        doctor_advice1.setInpatient(543334);
        for (int i = 0;i < 20 ; i++){
            list.add(doctor_advice);
            list.add(doctor_advice1);
        }
        return list;
    }

    public List<Doctor_Advice> initDoctorAdviceRecord(long inpatient){
        List<Doctor_Advice>list = new ArrayList<>();
        /**
         * 测试用假数据
         */
        Doctor_Advice doctor_advice = new Doctor_Advice();
        doctor_advice.setName("萨霍案");
        doctor_advice.setOrder_type("临时医嘱");
        doctor_advice.setDoc_order_content("5%葡萄糖溶液");
        doctor_advice.setEntry_time(new Date());
        doctor_advice.setInpatient(141455);
        for (int i = 0 ; i < 10;i++){
            list.add(doctor_advice);
        }
        return list;
    }

    public Doctor_Advice getAdvice(long inpatient){
        Doctor_Advice advice = new Doctor_Advice();

        /**
         * 测试用假数据
         */
        advice.setName("奥斯奇");
        advice.setInpatient(inpatient);
        advice.setEntry_time(new Date());
        advice.setDoc_order_content("sudhsdjnv;/dnbvs;ubn;ijaweiofjoew ");
        advice.setOrder_type("临时医嘱");
        advice.setStatus("未核查");
        return advice;
    }
    public void sendAdvice(Doctor_Advice advice){

    }
}
