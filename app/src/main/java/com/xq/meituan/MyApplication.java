package com.xq.meituan;

import android.app.Application;

import com.xq.meituan.recyclerview.util.ScreenUtil;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ScreenUtil.init(this);
    }

}