package com.befiring.dailyvideo.common;

import com.befiring.myutils.AppUtil;
import com.befiring.myutils.IoUtil;

/**
 * Created by wyman on 2018/3/13.
 */

public class AppDirectory {

    private static final String DIR_ROOT = "/DailyVideo";
    private static final String DIR_DB = "/db";
    private static final String DIR_LOG = "/log";
    public static final String DB_NAME="daily_video.db";

    private static final String FILENAME_COMMENT_LOG="/common_log.txt";
    private static final String FILENAME_CRASH_LOG="/crash_log.txt";

    public static String directoryDB;
    public static String directoryLog;
    public static String directoryCommOnLog;
    public static String directoryCrashLog;

    public static void init() {
        String rootPath = AppUtil.getSdPath()+ DIR_ROOT;
        IoUtil.createDirectory(rootPath);

        //创建db文件夹
        directoryDB=rootPath+ DIR_DB;
        IoUtil.createDirectory(directoryDB);

        //创建log文件夹
        directoryLog =rootPath+ DIR_LOG;
        IoUtil.createDirectory(directoryLog);

        //构造common_log.txt 和 crash_log.txt文件路径
        directoryCommOnLog=rootPath+DIR_LOG+FILENAME_COMMENT_LOG;
        directoryCrashLog=rootPath+DIR_LOG+FILENAME_CRASH_LOG;


    }
}
