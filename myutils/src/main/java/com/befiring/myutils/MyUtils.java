package com.befiring.myutils;


import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;

/**
 * Created by wyman on 2018/3/6.
 */

public class MyUtils {
    @SuppressLint("StaticFieldLeak")
    static Context CONTEXT;

    static String CRASH_LOG_PATH;

    static boolean IDE_LOG_ENABLED;

    static boolean FILE_LOG_ENABLED;

    private MyUtils() {

    }

    public static void init(MyUtilsConfiguration configuration) {
        CRASH_LOG_PATH = configuration.getCrashLogPath();
        IDE_LOG_ENABLED = configuration.isIdeLogEnabled();
        FILE_LOG_ENABLED = configuration.isFileLogEnabled();
        CONTEXT = configuration.getContext();

        if(!TextUtils.isEmpty(CRASH_LOG_PATH)){
            CrashHandler.getInstance().init();
        }
    }

}
