package com.example.nursingsystem.Presenter;

import com.example.nursingsystem.Model.Tranfusion_Form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransfusionPresenter {
    public List<Tranfusion_Form> initTransfusion(){
        List<Tranfusion_Form> list = new ArrayList<>();
        /**
         * Http连接服务端
         */
        Tranfusion_Form tranfusion_form = new Tranfusion_Form();
        tranfusion_form.setName("阿水哦");
        tranfusion_form.setBed_num(2211);
        tranfusion_form.setState("待收取");
        tranfusion_form.setDrug_name("5%葡萄糖溶液");
        tranfusion_form.setId(131654622);
        tranfusion_form.setInpatient(123464);
        tranfusion_form.setJob_num(13454);
        tranfusion_form.setTime(new Date());
        for(int i = 0 ; i < 20 ; i++) {
            list.add(tranfusion_form);
        }
        return list;
    }
    public List<Tranfusion_Form> searchOfInpatient(long inpatient){
        List<Tranfusion_Form> list1 = new ArrayList<>();
        Tranfusion_Form tranfusion_form = new Tranfusion_Form();
        tranfusion_form.setName("阿巴巴巴");
        tranfusion_form.setBed_num(2211);
        tranfusion_form.setState("待收取");
        tranfusion_form.setDrug_name("5%葡萄糖溶液");
        tranfusion_form.setId(131654622);
        tranfusion_form.setInpatient(123464);
        tranfusion_form.setJob_num(13454);
        tranfusion_form.setTime(new Date());
        for(int i = 0 ; i < 20 ; i++) {
            list1.add(tranfusion_form);
        }
        return list1;
    }
}
