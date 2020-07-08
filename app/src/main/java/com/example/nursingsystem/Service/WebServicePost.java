package com.example.nursingsystem.Service;

import com.example.nursingsystem.Model.Nurse;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class WebServicePost {
   private static String SERVER_URL = "http://10.0.2.2:8080/SMCSWebService/WebService";

   public static String Post(String json){
       String msg = "";
       try{
           HttpURLConnection conn = (HttpURLConnection) new URL(SERVER_URL).openConnection();
           //设置请求方式，请求超时信息
           conn.setRequestMethod("POST");
           conn.setReadTimeout(5000);
           conn.setConnectTimeout(5000);
           //设置运行输入输出
           conn.setDoOutput(true);
           conn.setDoInput(true);
           //POST方式不能缓存，需手动设置为false
           conn.setUseCaches(false);
           //获取输出流
           OutputStream out = conn.getOutputStream();
           out.write(json.getBytes());
           out.flush();
           if (conn.getResponseCode() == 200){
               //获取响应的输入流对象
               InputStream is = conn.getInputStream();
               //创建字节输出流对象
               ByteArrayOutputStream message = new ByteArrayOutputStream();
               //定义读取的长度
               int len = 0;
               //定义缓冲区
               byte buffer[] = new byte[1024];
               //按照缓冲区的大小，循环读取
               while ((len = is.read(buffer)) != -1) {
                   message.write(buffer,0,len);
               }
               //释放资源
               is.close();
               message.close();
               //返回字符串
               msg = new String(message.toByteArray());
               return msg;
           }
       }catch (Exception e){
           e.printStackTrace();
       }
       return msg;
   }

    public static String sendRequestWithOkHttp(String json){
        String responseData = "";
                try {
                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody = new FormBody.Builder().add("json",json).build();
                    Request request = new Request.Builder().url(SERVER_URL).post(requestBody).build();
                    Response response = client.newCall(request).execute();
                    responseData = response.body().string();
                }catch (Exception e){
                    e.printStackTrace();
                }

        return responseData;
    }

}
