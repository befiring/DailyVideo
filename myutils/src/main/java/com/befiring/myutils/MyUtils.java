package com.befiring.myutils;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

/**
 * Created by wyman on 2018/3/6.
 */

public class MyUtils {

    @SuppressLint("StaticFieldLeak")
    private static MyUtils instance;

    @SuppressLint("StaticFieldLeak")
    protected static Context CONTEXT;



    public static void setUp(Application application) {
        CONTEXT = application.getApplicationContext();
    }




}
