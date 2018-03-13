package com.befiring.myutils;

import android.content.Context;

/**
 * Created by wyman on 2018/3/13.
 */

public class MyUtilsConfiguration {

    private static String CRASH_LOG_PATH;

    private static boolean IDE_LOG_ENABLED;

    private static boolean FILE_LOG_ENABLED;


    public static void setCrashLogPath(String path) {
        CRASH_LOG_PATH = path;
        CrashHandler.getInstance().init();
    }

    public static void setIdeLogEnabled(boolean ideLogEnabled) {
        IDE_LOG_ENABLED = ideLogEnabled;
    }

    public static void setFileLogEnabled(boolean fileLogEnabled) {
        FILE_LOG_ENABLED = fileLogEnabled;
    }

    private MyUtilsConfiguration() {
    }

    public void Build(Builder builder){
        CRASH_LOG_PATH = builder.CRASH_LOG_PATH;
        IDE_LOG_ENABLED = builder.IDE_LOG_ENABLED;
        FILE_LOG_ENABLED = builder.FILE_LOG_ENABLED;
    }

    class Builder {
        private Context context;

        private  String CRASH_LOG_PATH;

        private  boolean IDE_LOG_ENABLED;

        private  boolean FILE_LOG_ENABLED;

        public Builder(Context context) {
            this.context=context;
        }

        public Builder crashLogPath(String path){
            this.CRASH_LOG_PATH = path;
            return this;
        }

        public Builder ideLogEnabled(boolean enabled){
            this.IDE_LOG_ENABLED = enabled;
            return this;
        }

        public Builder fileLogEnabled(boolean enabled){
            this.FILE_LOG_ENABLED = enabled;
            return this;
        }
    }
}
