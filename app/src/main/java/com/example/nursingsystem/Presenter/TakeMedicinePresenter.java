package com.example.nursingsystem.Presenter;

import com.example.nursingsystem.Model.Take_Medicine_Form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TakeMedicinePresenter {

    public List<Take_Medicine_Form> initTakeMedicineForm(){
        List<Take_Medicine_Form> list1 = new ArrayList<>();
        /**
         * Http连接服务端
         */
        Take_Medicine_Form take_medicine_form = new Take_Medicine_Form();
        take_medicine_form.setBed_num(1325);
        take_medicine_form.setElixir("5%葡萄糖溶液");
        take_medicine_form.setId(123156);
        take_medicine_form.setJob_num(12355);
        take_medicine_form.setName("阿克苏吉");
        take_medicine_form.setInpatient(123145);
        take_medicine_form.setState("已收取");
        take_medicine_form.setTime(new Date());
        for (int i = 0 ; i < 20 ; i++){
            list1.add(take_medicine_form);
        }
        return list1;
    }

    public List<Take_Medicine_Form> searchOfInpatient(long inpatient) {
        List<Take_Medicine_Form> list1 = new ArrayList<>();
        Take_Medicine_Form take_medicine_form = new Take_Medicine_Form();
        take_medicine_form.setBed_num(13125);
        take_medicine_form.setElixir("5%葡萄糖溶液");
        take_medicine_form.setId(1231256);
        take_medicine_form.setJob_num(12124);
        take_medicine_form.setName("奥斯丁jam");
        take_medicine_form.setInpatient(123145);
        take_medicine_form.setState("已收取");
        take_medicine_form.setTime(new Date());
        for (int i = 0 ; i < 20 ; i++){
            list1.add(take_medicine_form);
        }
        return list1;
    }
}
