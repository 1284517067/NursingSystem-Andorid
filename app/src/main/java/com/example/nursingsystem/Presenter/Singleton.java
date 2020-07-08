package com.example.nursingsystem.Presenter;

import java.util.HashMap;

public class Singleton {
    //单例模式实例
    private static Singleton instance = null;

    //synchronized 用于线程安全，防止多线程同时创建实例
    public synchronized  static Singleton getInstance(){
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    final HashMap<String,Object> map;

    private Singleton(){
        map = new HashMap<String, Object>();
    }

    public void put(String key,Object value) {
        map.put(key,value);
    }
    public Object get(String key) {
        return  map.get(key);
    }

}
