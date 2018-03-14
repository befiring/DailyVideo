package com.befiring.dailyvideo;

import android.app.Application;

import com.befiring.dailyvideo.common.AppDirectory;
import com.befiring.myutils.MyUtils;
import com.befiring.myutils.MyUtilsConfiguration;

/**
 * Created by WangMeng on 2018/3/6.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppDirectory.init();
        MyUtilsConfiguration configuration=new MyUtilsConfiguration.Builder(this).crashLogPath(AppDirectory.directoryCrashLog)
                .ideLogEnabled(BuildConfig.DEBUG)
                .fileLogEnabled(!BuildConfig.DEBUG)
                .build();
        MyUtils.init(configuration);
    }
}
