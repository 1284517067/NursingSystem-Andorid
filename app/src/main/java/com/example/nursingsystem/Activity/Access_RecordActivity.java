package com.example.nursingsystem.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.os.Bundle;

import com.example.nursingsystem.Fragment.NavbarFlagment;
import com.example.nursingsystem.Fragment.ToolbarFragment;
import com.example.nursingsystem.Model.Access_Form;
import com.example.nursingsystem.Presenter.AccessPresenter;
import com.example.nursingsystem.R;
import com.example.nursingsystem.Service.Adapter.Access_RecordAdapter;

import java.util.ArrayList;
import java.util.List;

public class Access_RecordActivity extends AppCompatActivity {

    private ToolbarFragment toolbarFragment;
    private NavbarFlagment navbarFlagment;
    private RecyclerView recyclerView;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access__record);
        context = Access_RecordActivity.this;
        bindView();
        toolbarFragment.setTitle("历史出入记录");
        List<Access_Form> list = new ArrayList<>();
        AccessPresenter presenter = new AccessPresenter();
        list = presenter.getRecordList();
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        Access_RecordAdapter adapter = new Access_RecordAdapter(list,context);
        recyclerView.setAdapter(adapter);
    }

    private void bindView(){
        toolbarFragment = (ToolbarFragment)getSupportFragmentManager().findFragmentById(R.id.ar_toolbar);
        navbarFlagment = (NavbarFlagment)getSupportFragmentManager().findFragmentById(R.id.ar_navbar);
        recyclerView = (RecyclerView)findViewById(R.id.ar_list);
    }
}
