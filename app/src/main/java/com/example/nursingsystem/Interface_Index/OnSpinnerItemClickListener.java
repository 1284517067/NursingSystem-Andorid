package com.example.nursingsystem.Interface_Index;

import android.view.View;
import android.widget.AdapterView;

/**
 * 下拉列表的item点击事件，即listView的item点击事件
 */
public interface OnSpinnerItemClickListener {
    void onItemClick(AdapterView<?> parent, View view , int position, long id);
}
