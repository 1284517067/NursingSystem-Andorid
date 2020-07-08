package com.example.nursingsystem.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nursingsystem.Model.Nurse;
import com.example.nursingsystem.Presenter.JumpTextWatcher;
import com.example.nursingsystem.Presenter.NursePresenter;
import com.example.nursingsystem.Presenter.ShareHelper;
import com.example.nursingsystem.Presenter.Singleton;
import com.example.nursingsystem.R;
import com.example.nursingsystem.Service.DecodeJSON;
import com.example.nursingsystem.Service.GetJson;
import com.example.nursingsystem.Service.MD5;
import com.example.nursingsystem.Service.WebServicePost;

import org.json.JSONObject;

import java.util.Map;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

    private static String SERVER_URL = "http://10.0.2.2:8080/SMCSWebService/WebService";
    private static final  int GOTO = 1;
    private EditText account;
    private EditText password;
    private Button sign_in;
    private CheckBox remember;
    private Context context;
    private ShareHelper sh;
    private NursePresenter nursePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindViews();
        nursePresenter = new NursePresenter();
        context = LoginActivity.this;
        sh = new ShareHelper(context);
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(account.getText())){
                    Log.d("login", "account is empty....");
                    Toast.makeText(context,"请输入工号",Toast.LENGTH_SHORT).show();
                }else {
                    if (TextUtils.isEmpty(password.getText())){
                        Log.d("login", "password is empty....");
                        Toast.makeText(context,"请输入密码",Toast.LENGTH_SHORT).show();
                    }else {
                        String username = account.getText().toString();
                        String pwd = password.getText().toString();
                        Log.d("login", "account = " + username + " password = "+pwd);
                        Nurse nurse = new Nurse();
                        nurse.setJob_num(Integer.parseInt(username));
                        nurse.setPassword(MD5.getMD5(pwd));
                        /*nurse.setName("埃苏丹");
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        Singleton.getInstance().put("nurse",nurse);
                        startActivity(intent);*/
                        /**
                         * 数据库验证
                         */
                        new Thread() {
                            public void run(){
                                Looper.prepare();
                                String result = "";
                                try{
                                    OkHttpClient client = new OkHttpClient();
                                    RequestBody requestBody = new FormBody.Builder()
                                            .add("job_num",nurse.getJob_num()+"")
                                            .add("password",nurse.getPassword())
                                            .add("type","login")
                                            .build();
                                    Request request = new Request.Builder().url(SERVER_URL).post(requestBody).build();
                                    Response response = client.newCall(request).execute();
                                    result = response.body().string();
                                    Log.d("login", "result = "+result);
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                Log.d("login", "result = "+result);
                                if(result == null || result == "" ){
                                    Log.d("login", "failed to connect server...");
                                    Toast.makeText(context,"连接服务器失败",Toast.LENGTH_SHORT).show();
                                }else {
                                    try {
                                        JSONObject object = new JSONObject(result);
                                        String msgtype = object.getString("msgtype");
                                        if (msgtype.equals("error")){
                                            String msg = object.getString("errormsg");
                                            Log.d("login", msg);
                                            Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
                                        } else {
                                            if(remember.isChecked()) {
                                                Log.d("login", "CheckBox is checked. Ready to save account");
                                                sh.saveAccount(username);
                                                Log.d("login", "Save complete");
                                            } else {
                                                sh.remove(context,"account");
                                            }
                                            Nurse nurse1 = DecodeJSON.getNurseOnJSON(result);
                                            Singleton.getInstance().put("nurse",nurse1);
                                            Intent intent = new Intent(context,MainActivity.class);
                                            startActivity(intent);
                                            Message message = new Message();
                                            message.what = GOTO;

                                            //handler.sendMessage(message);
                                        }
                                    }catch (Exception e){
                                        e.printStackTrace();
                                    }
                                }
                                Looper.loop();
                            }

                        }.start();
                }

                }
            }
        });
    }
    final Handler handler = new Handler(){
        public void handleMessage(Message msg){
            if(msg.what == GOTO){

            }
        }
    };
    protected void  onStart(){
        super.onStart();
        if (sh.contains(context,"account")){
            Map<String,String> data = sh.readAccount();
            String account1 = data.get("account");
            account.setText(account1);
            remember.setChecked(true);
        }
    }

    private void bindViews(){
        account = (EditText) findViewById(R.id.account);
        password = (EditText) findViewById(R.id.password);
        sign_in = (Button) findViewById(R.id.sign_in);
        remember = (CheckBox)findViewById(R.id.check_remember_account);
        account.addTextChangedListener(new JumpTextWatcher(account,password));
        password.addTextChangedListener(new JumpTextWatcher(password,null));
    }
}
