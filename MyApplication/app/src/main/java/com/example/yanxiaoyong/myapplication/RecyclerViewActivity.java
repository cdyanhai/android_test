package com.example.yanxiaoyong.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yanxiaoyong.myapplication.widget.DividerItemDecoration;
import com.example.yanxiaoyong.myapplication.widget.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private HomeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        initData();
        mRecyclerView = (RecyclerView)findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter = new HomeAdapter(mDatas));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this));
        mAdapter.setOnItemClickListener(new HomeAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String data) {

            }
        });
    }



    protected void initData(){
        mDatas = new ArrayList<String>();
        for (int i='A'; i<'Z'; ++i){
            mDatas.add("" + (char)i);
        }
    }



}
