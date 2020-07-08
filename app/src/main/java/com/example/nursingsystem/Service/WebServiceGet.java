package com.example.nursingsystem.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebServiceGet {

    public static String executeHttpGet(String address){
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        try {
            String Url = "http://localhost:8080/WebService/" + address;
            String path = Url ;//要传输的数据
            try {
                URL url = new URL(path);
                connection = (HttpURLConnection)url.openConnection();
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(10000);//建立连接超时
                connection.setReadTimeout(8000);//传递数据超时

                inputStream = connection.getInputStream();
                return parseInfo(inputStream);

            }catch (Exception e){
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            //意外退出时，关闭连接保护
            if (connection != null){
                connection.disconnect();
            }
            if (inputStream != null){
                try {
                    inputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        }
        return null;
    }

    //得到字节输入流，将字节输入流转化为String类型
    public static String parseInfo(InputStream inputStream){
        BufferedReader reader = null;
        String line = "";
        StringBuilder response = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = reader.readLine()) != null){
                response.append(line);
            }
            return response.toString();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(reader != null){
                try {
                    reader.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
