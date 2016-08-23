package com.example.yanxiaoyong.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.yanxiaoyong.myapplication.db.User;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import okhttp3.Call;
import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Realm realm;
    private RealmConfiguration realmConfig;
    private TextView mTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView3);
        textView.setMovementMethod(new ScrollingMovementMethod());
        mTv = (TextView)findViewById(R.id.textView);


        realmConfig = new RealmConfiguration.Builder(this).build();
        realm = Realm.getInstance(realmConfig);

        realm.executeTransaction(new Realm.Transaction(){
            @Override
            public void execute(Realm realm){
                User user = realm.createObject(User.class);
                user.setName("AAA");
                user.setAge(10);
            }
        });

        EventBus.getDefault().register(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(0,1,1,"Exit");
        menu.add(0, 2, 2, "About");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==1)
        {
            finish();
        }
        if(item.getItemId()==2)
        {
            textView.setText(item.getTitle());
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void OnClick(View view){

//        RealmResults<User> results = realm.where(User.class).findAll();
//        String str = new String();
//        int n = results.size();
//        for(User u : results){
//            str += u.getName().toString();
//        }
//
//        str += String.valueOf(n);
//        new AlertDialog.Builder(this)
//                .setTitle("确认")
//                .setMessage(str)
//                .setPositiveButton("是", null)
//                .setNegativeButton("否", null)
//                .show();

        Intent intent = new Intent();
        //intent.setClass(MainActivity.this, ListActivity.class);
        intent.setClass(MainActivity.this, Welcome.class);
        startActivity(intent);
    }

    public void OnClick2(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, List2Activity.class);
        startActivity(intent);
    }

    public void OnClick3(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, RecyclerViewActivity.class);
        startActivity(intent);
    }

    public void OnGetClick(View view){
        String url = "http://www.jd.com";
        OkHttpUtils.get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        String  html = response;
                        textView.setText(html);
                    }

                    @Override
                    public void inProgress(float progress, long total, int id) {
                        super.inProgress(progress, total, id);
                    }
                });
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void OnShowMsgEvent(MsgEvent msgEnent){
        mTv.setText("EventBus Msg:" + msgEnent.getMsg());
    }


    public  void  OnViewPagerClick(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ViewPageActivity.class);
        startActivity(intent);
    }

    public void OnFragment(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, FragmentActivity.class);
        startActivity(intent);
    }

    public  void OnAsyncTaskClick(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, AsyncTaskActivity.class);
        startActivity(intent);
    }

    public void OnRecycleView2(View view){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, RecyclerViewActivity2.class);
        startActivity(intent);
    }

}
