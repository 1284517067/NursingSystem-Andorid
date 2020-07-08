package com.example.nursingsystem.Service;

import com.example.nursingsystem.Model.Care_Form;
import com.example.nursingsystem.Model.Nurse;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DecodeJSON {
    public static Nurse getNurseOnJSON (String json){
        Nurse nurse = new Nurse();
        try {
           /* JSONObject object = new JSONObject(json);
            nurse.setJob_num(object.getInt("job_num"));
            nurse.setPassword(object.getString("password"));
            nurse.setAdmission_time(dateToString(object.getString("admisstion_time")));
            nurse.setTel(object.getString("tel"));
            nurse.setBirth(dateToString(object.getString("birth")));
            nurse.setBlood(object.getString("blood"));
            nurse.setDepartment(object.getString("department"));
            nurse.setEducation(object.getString("education"));
            nurse.setEmail(object.getString("email"));
            nurse.setGraduated(object.getString("graduated"));
            nurse.setJob_title(object.getString("job_title"));
            nurse.setMarital_status(object.getString("marital_status"));
            nurse.setName(object.getString("name"));
            nurse.setSex(object.getString("sex"));
            nurse.setNation(object.getString("nation"));
            nurse.setPolitical_status(object.getString("political_status"));*/
            Gson gson = new Gson();
            nurse = gson.fromJson(json,Nurse.class);
            return nurse;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static List<Care_Form> getCareFormListOnJSON(String json){
        List<Care_Form>list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0 ; i < jsonArray.length() ;i++){
                JSONObject jsonObject = (JSONObject)jsonArray.get(i);
                Care_Form care_form = new Care_Form();
                care_form.setInpatient(jsonObject.getInt("inpatient"));
                care_form.setContent(jsonObject.getString("content"));
                care_form.setCaretype(jsonObject.getString("catetype"));
                care_form.setCare_list(jsonObject.getInt("care_list"));
                care_form.setName(jsonObject.getString("name"));
                list.add(care_form);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public static Date dateToString(String str){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition position = new ParsePosition(0);
        Date date = format.parse(str,position);
        return date;
    }

}
