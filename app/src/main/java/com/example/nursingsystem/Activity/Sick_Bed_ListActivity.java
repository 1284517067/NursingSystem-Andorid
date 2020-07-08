package com.example.nursingsystem.Activity;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.nursingsystem.Interface_Index.OnRecyclerItemClkickListener;
import com.example.nursingsystem.Model.SickBed;
import com.example.nursingsystem.Presenter.SickBedPresenter;
import com.example.nursingsystem.R;
import com.example.nursingsystem.Service.Adapter.DepartmentAdapter;
import com.example.nursingsystem.Service.Adapter.SickBedAdapter;
import com.example.nursingsystem.Service.Factory;

import java.util.List;

public class Sick_Bed_ListActivity extends AppCompatActivity {

    private Context mContext;
    private RecyclerView departmentrecyclerView;
    private RecyclerView sickbedrecyclerView;
    private List<String> departmentList;
    private List<SickBed> sickBedList;
    private TextView department;
    private SickBedAdapter sickBedAdapter;
    private Button back;
    private ImageView menu;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = Sick_Bed_ListActivity.this;
        setContentView(R.layout.sickbed_list);
        bindView();
        department.setText("呼吸科");
        StaggeredGridLayoutManager layoutManager = new
                StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        sickbedrecyclerView.setLayoutManager(layoutManager);
        /*String _department = getIntent().getStringExtra("setDepartment");
        if (_department == null){*/

            sickBedList = SickBedPresenter.initSickBed();
       /* }else {
            reSetDepartment(_department);
        }*/
        sickBedAdapter = new SickBedAdapter(mContext,sickBedList);
        sickbedrecyclerView.setAdapter(sickBedAdapter);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        department.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initPopWindow(v);
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    /**
     * 绑定控件
     */
    public void bindView(){
        department = (TextView)findViewById(R.id.sickbed_department);
        sickbedrecyclerView = (RecyclerView)findViewById(R.id.sickbed_bed);
        back = (Button)findViewById(R.id.sickbed_back);
        menu = (ImageView)findViewById(R.id.sickbed_fold);
    }

    /**
     * 初始化列表PopupWindow
     */
    public void initPopWindow(View v){
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_popup,null,false);
        departmentrecyclerView = (RecyclerView)view.findViewById(R.id.pop_department);
        //departmentList = Factory.getDepartmentList();
        departmentList = SickBedPresenter.initDepartment();
        /**
         * 构造一个PopupWindow
         */
        final PopupWindow popupWindow = new PopupWindow(view,
                ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);
        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        //设置背景
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x60000000));
        //设置popupWindow显示的位置
        popupWindow.showAsDropDown(v,0,45);
        departmentrecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        DepartmentAdapter adapter = new DepartmentAdapter(mContext,departmentList);
        departmentrecyclerView.setAdapter(adapter);
    }

    /**
     * 菜单筛选项
     */
    public void initMenuWindow(View v){
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_menu,null,false);
        TextView one = (TextView)view.findViewById(R.id.item_one);
        TextView two = (TextView)view.findViewById(R.id.item_two);
        TextView three = (TextView)view.findViewById(R.id.item_three);
        TextView intensive = (TextView)view.findViewById(R.id.item_intensive);

        //构造
        final PopupWindow popupWindow = new PopupWindow(view,ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);

        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));

        //设置点击事件
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        intensive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }


    public void reSetDepartment(String mdepartment)
    {
        department.setText(mdepartment);
        /**
         * 筛选符合科室的病床列表
         */
        sickBedList = SickBedPresenter.SearchSickBed(mdepartment);
        //sickBedAdapter.notifyDataSetChanged();
        onResume();
    }
}
