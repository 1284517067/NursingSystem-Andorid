package com.example.nursingsystem.Presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class ShareHelper {
    private Context context;

    public ShareHelper (){

    }
    public ShareHelper(Context context1){
        this.context = context1;
    }

    /**
     * 保存数据
     */
    public void saveAccount(String account) {
        Log.d(TAG, "ready to save account... ");
        SharedPreferences sp = context.getSharedPreferences("mysp",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("account",account);
        editor.commit();
        Log.d(TAG, "saveAccount complete: " + account);
    }

    /**
     * 读取数据
     */
    public Map<String,String> readAccount() {
        Map<String,String> data = new HashMap<>();
        SharedPreferences sp = context.getSharedPreferences("mysp",Context.MODE_PRIVATE);
        data.put("account",sp.getString("account",""));
        return data;
    }

    /**
     * 删除数据
     */
    public void remove(Context context1,String key) {
        SharedPreferences sp = context1.getSharedPreferences("mysp",context1.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.commit();
    }

    /**
     * 查询KEY值是否存在
     */
    public boolean contains(Context context1,String key) {
        SharedPreferences sharedPreferences = context1.getSharedPreferences("mysp",context1.MODE_PRIVATE);
        return sharedPreferences.contains(key);
    }
}
