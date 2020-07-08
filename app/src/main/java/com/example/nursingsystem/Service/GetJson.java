package com.example.nursingsystem.Service;

import org.json.JSONObject;

public class GetJson {
    public static String toLoginJson(String usr,String pwd){
        String data = "";
        try {
            JSONObject object = new JSONObject();
            object.put("type","login");
            object.put("account",usr);
            object.put("password",pwd);
            data = object.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
     return data;
    }
}
