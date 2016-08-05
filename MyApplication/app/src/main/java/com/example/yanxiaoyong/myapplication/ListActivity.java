package com.example.yanxiaoyong.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

//    private static final String[] strs = new String[]{
//        "first", "second", "third", "fourth", "fifth"
//    };

    private List<String> mStrs;

    private  ListView mLv;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mStrs = new ArrayList<String>();

        for (int i='A'; i<'Z'; i++)
        {
            mStrs.add(""+ (char)i);
        }

        mLv = (ListView)findViewById(R.id.listView);
        mTv = (TextView)findViewById(R.id.textView3);

        mLv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, mStrs));
        mLv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mTv.setText("你点击了第" + i + "行");
            }
        });


    }
}
