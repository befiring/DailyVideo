package com.befiring.myutils;

import android.app.Application;

/**
 * Created by wyman on 2018/3/6.
 */

public class MyUtils {

    protected static Application application;
    public boolean isCrashHandlerEnabled;

    public static MyUtils crashHandlerEnabled(boolean isCrashHandlerEnabled){
        this.isCrashHandlerEnabled=isCrashHandlerEnabled;
        return this;
    }

}
