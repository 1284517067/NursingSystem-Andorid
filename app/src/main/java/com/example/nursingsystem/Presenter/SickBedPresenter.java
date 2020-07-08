package com.example.nursingsystem.Presenter;

import com.example.nursingsystem.Model.SickBed;

import java.util.ArrayList;
import java.util.List;

public class SickBedPresenter {
    public static List<String> initDepartment(){
        List<String> list = new ArrayList<String>();
        /**
         * 数据库操作
         */
        for (int i = 0 ; i < 10 ; i++){
            list.add("第"+i+"个科室");
        }
        return list;
    }

    public static List<SickBed> initSickBed(){
        List<SickBed> list = new ArrayList<SickBed>();
        /**
         * 数据库操作
         */


        SickBed sickBed = new SickBed();
        sickBed.setAge(12);
        sickBed.setAlready_paid(1123);
        sickBed.setBed_num(123);
        sickBed.setDepartment("科室");
        sickBed.setDiagnosis("salkiudjh");
        sickBed.setInpatient(123154);
        sickBed.setName("送快递");
        sickBed.setPrepayments(123);
        sickBed.setSex("男");
        sickBed.setCarelevel("一级护理");
        sickBed.setTotal(154641);
        for (int i = 0 ; i < 20 ; i++){
            list.add(sickBed);
        }
        return list;
    }

    public static List<SickBed>SearchSickBed(String department){
        List<SickBed> list = new ArrayList<SickBed>();
        /**
         * 数据库操作
         */
        return list;
    }

    public List<SickBed> SearchSickBedOfCareLevel(String careLevel){
        List<SickBed> list = new ArrayList<>();
        /**
         * 网络连接服务端请求数据
         */
        return list;
    }
}
