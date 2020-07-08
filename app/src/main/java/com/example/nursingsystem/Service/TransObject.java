package com.example.nursingsystem.Service;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;

public class TransObject extends AsyncTask<Object,Void,Object> {
    @Override
    protected Object doInBackground(Object... objects) {
        StringBuffer sb = new StringBuffer();
        Object object = objects[0];
        BufferedReader reader = null;
        HttpURLConnection connection = null;
        ObjectOutputStream objectOutputStream = null;
        try{

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
