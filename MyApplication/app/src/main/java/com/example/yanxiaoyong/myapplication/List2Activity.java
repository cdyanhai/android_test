package com.example.yanxiaoyong.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class List2Activity extends AppCompatActivity {

    private ListView mLv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_img);

        mLv = (ListView)findViewById(R.id.listView2);
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String,     Object>>();/*在数组中存放数据*/
        for(int i=0;i<10;i++)
        {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImage", R.mipmap.icon);//加入图片            map.put("ItemTitle", "第"+i+"行");
            map.put("ItemText", "这是第"+i+"行");
            listItem.add(map);
        }
        SimpleAdapter mSimpleAdapter = new SimpleAdapter(this,listItem,//需要绑定的数据
                R.layout.item,                  //每一行的布局//动态数组中的数据源的键对应到定义布局的View中
                new String[] {"ItemImage" ,"ItemTitle", "ItemText"},
            new int[] {R.id.imageView3,R.id.textView4,R.id.textView5}
    );

    mLv.setAdapter(mSimpleAdapter);//为ListView绑定适配器

        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> agr0, View arg1, int arg2,   long arg3) {
            setTitle("你点击了第"+arg2+"行");//设置标题栏显示点击的行
        }
    });
}

    }
}
