package com.befiring.myutils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Wang Meng on 2017/8/24.
 */

/**
 * 时间相关工具类
 */
public class TimeUtil {

    private static final String FORMAT="yyyy-MM-dd HH:mm:ss";

    public static String getNow(){
        Date date=new Date();
        SimpleDateFormat formatter=new SimpleDateFormat(FORMAT, Locale.CHINA);
        return formatter.format(date);
    }
}
