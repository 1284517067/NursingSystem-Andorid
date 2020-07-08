package com.example.nursingsystem.Interface_Index;

import android.view.View;

/**
 * 下拉列表显示与隐藏事件
 */
public interface WindowStatusListener {
    /**
     * 下拉列表显示
     */
    void onShow(View view);
    /**
     * 下拉列表隐藏
     */
    void onDismiss(View view);
}
