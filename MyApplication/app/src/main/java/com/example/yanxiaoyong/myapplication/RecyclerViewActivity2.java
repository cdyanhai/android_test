package com.example.yanxiaoyong.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.yanxiaoyong.myapplication.widget.GalleryAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecyclerViewActivity2 extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private GalleryAdapter mAdapter;
    private List<Integer> mDatas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view2);
        initDatas();
        //得到控件
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview_horizontal);
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        //设置适配器
        mAdapter = new GalleryAdapter(this, mDatas);
        mRecyclerView.setAdapter(mAdapter);


    }


    private void initDatas()
    {
        mDatas = new ArrayList<Integer>(Arrays.asList(R.drawable.a,
                R.mipmap.b, R.mipmap.c, R.mipmap.d, R.mipmap.e,
                R.mipmap.f, R.mipmap.g, R.mipmap.h, R.mipmap.l));
    }
}
