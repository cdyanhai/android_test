package com.example.yanxiaoyong.myapplication;

import android.app.Application;

import com.zhy.http.okhttp.OkHttpUtils;

import okhttp3.OkHttpClient;

/**
 * Created by yanxiaoyong on 2016/8/17.
 */
public class TestApplication extends Application {
    @Override
    public void onCreate() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, java.util.concurrent.TimeUnit.MILLISECONDS)
                .readTimeout(10000L, java.util.concurrent.TimeUnit.MILLISECONDS )
                .build();

        OkHttpUtils.initClient(okHttpClient);

        super.onCreate();
    }
}
