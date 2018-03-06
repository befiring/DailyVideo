package com.befiring.dailyvideo;

import android.app.Application;

import com.befiring.myutils.MyUtils;

/**
 * Created by wyman on 2018/3/6.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MyUtils.crashHandlerEnabled(true)
    }
}
