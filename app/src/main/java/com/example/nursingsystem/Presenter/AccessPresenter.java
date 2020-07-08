package com.example.nursingsystem.Presenter;

import com.example.nursingsystem.Model.Access_Form;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccessPresenter {
    public boolean sendAccessForm(Access_Form access_form){
        boolean flag;
        flag = true;
        return flag;
    }

    public boolean updateAccessForm(Access_Form access_form){
        boolean flag;
        flag = true;
        return flag;
    }

    public List<Access_Form> getNotBackForm(){
        List<Access_Form> list = new ArrayList<>();
        Access_Form access_form = new Access_Form();
        Access_Form access_form1 = new Access_Form();
        try{
            access_form.setName("张三");
            access_form.setStatus("未回室");
            access_form.setInpatient(1231255);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = format.parse("2020-1-31 12:00:00");
            access_form.setOut(date);
            date = format.parse("2020-2-1 12:00:00");
            access_form.setBack(date);
            access_form.setReason("私事");
            access_form1.setName("李四");
            access_form1.setStatus("未回室");
            access_form1.setInpatient(1231255);
            date = format.parse("2020-1-31 12:00:00");
            access_form1.setOut(date);
            date = format.parse("2020-2-1 12:00:00");
            access_form1.setBack(date);
            access_form1.setReason("私事");
            list.add(access_form);
            list.add(access_form1);
        }catch (Exception e){
            e.printStackTrace();
        }
       return list;
    }

    public List<Access_Form> getRecordList(){
        List<Access_Form> list = new ArrayList<>();
        Access_Form access_form = new Access_Form();
        try {
            access_form.setName("张三");
            access_form.setStatus("已确认回室");
            access_form.setInpatient(1231255);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = format.parse("2020-1-31 12:00:00");
            access_form.setOut(date);
            date = format.parse("2020-2-1 12:00:00");
            access_form.setBack(date);
            access_form.setReason("私事");
            list.add(access_form);
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;

    }
}
