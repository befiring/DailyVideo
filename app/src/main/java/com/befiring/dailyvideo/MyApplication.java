package com.befiring.dailyvideo;

import android.app.Application;

import com.befiring.dailyvideo.common.AppDirectory;
import com.befiring.myutils.MyUtils;

/**
 * Created by wyman on 2018/3/6.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppDirectory.init();
        MyUtils.setUp(this);
        MyUtils.setCrashLogPath(AppDirectory.directoryCrashLog);
        MyUtils.setIdeLogEnabled(BuildConfig.DEBUG);
        MyUtils.setFileLogEnabled(!BuildConfig.DEBUG);
    }
}
