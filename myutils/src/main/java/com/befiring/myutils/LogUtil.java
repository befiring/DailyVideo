package com.befiring.myutils;


import android.util.Log;

/**
 * Created by wyman on 2018/3/13.
 */

public class LogUtil {

    public static void d(String tag, String msg) {
        if (MyUtils.IDE_LOG_ENABLED) {
            Log.d(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (MyUtils.IDE_LOG_ENABLED) {
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (MyUtils.IDE_LOG_ENABLED) {
            Log.e(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (MyUtils.IDE_LOG_ENABLED) {
            Log.i(tag, msg);
        }
    }

    public static void v(String tag, String msg) {
        if (MyUtils.IDE_LOG_ENABLED) {
            Log.v(tag, msg);
        }
    }

    public static void f(String filePath, String msg){
        if(MyUtils.FILE_LOG_ENABLED){
            IoUtil.writeToFileA(filePath,msg);
        }
    }
}
