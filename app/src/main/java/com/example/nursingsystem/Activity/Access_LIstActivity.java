package com.example.nursingsystem.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nursingsystem.Fragment.NavbarFlagment;
import com.example.nursingsystem.Fragment.ToolbarFragment;
import com.example.nursingsystem.Model.Access_Form;
import com.example.nursingsystem.Presenter.AccessPresenter;
import com.example.nursingsystem.R;
import com.example.nursingsystem.Service.Adapter.AccessAdapter;

import java.util.ArrayList;
import java.util.List;

public class Access_LIstActivity extends AppCompatActivity {

    private ToolbarFragment toolbarFragment;
    private NavbarFlagment navbarFlagment;
    private RecyclerView listview;
    private TextView record;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_list);
        context = Access_LIstActivity.this;
        bindView();
        toolbarFragment.setTitle("出入管理");
        List<Access_Form> list = new ArrayList<>();
        AccessPresenter presenter = new AccessPresenter();
        list = presenter.getNotBackForm();
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        listview.setLayoutManager(manager);
        AccessAdapter accessAdapter = new AccessAdapter(list,context);
        listview.setAdapter(accessAdapter);
        SpannableString span = new SpannableString("历史出入记录");
        span.setSpan(new UnderlineSpan(),0,6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        record.setText(span);
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Access_RecordActivity.class);
                startActivity(intent);
            }
        });

    }

    private void bindView(){
        toolbarFragment = (ToolbarFragment)getSupportFragmentManager().findFragmentById(R.id.al_toolbar);
        navbarFlagment = (NavbarFlagment)getSupportFragmentManager().findFragmentById(R.id.al_navbar);
        record = (TextView)findViewById(R.id.al_record);
        listview = (RecyclerView)findViewById(R.id.al_list);
    }

}
