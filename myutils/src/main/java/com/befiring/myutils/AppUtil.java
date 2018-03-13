package com.befiring.myutils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;


import java.lang.reflect.Array;
import java.lang.reflect.Method;

/**
 * Created by Wang Meng on 2017/8/24.
 */

/**
 * Android API相关的工具类
 */
public class AppUtil {

    /**
     * 获取内置SD卡路径
     */
    public static String getSdPath() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        return "";
    }


    /**
     * 获取扩展SD卡路径
     */
    private static String getExtendedMemoryPath(Context mContext) {

        StorageManager mStorageManager = (StorageManager) mContext.getSystemService(Context.STORAGE_SERVICE);
        Class<?> storageVolumeClazz = null;
        try {
            storageVolumeClazz = Class.forName("android.os.storage.StorageVolume");
            Method getVolumeList = mStorageManager.getClass().getMethod("getVolumeList");
            Method getPath = storageVolumeClazz.getMethod("getPath");
            Method isRemovable = storageVolumeClazz.getMethod("isRemovable");
            Object result = getVolumeList.invoke(mStorageManager);
            final int length = Array.getLength(result);
            for (int i = 0; i < length; i++) {
                Object storageVolumeElement = Array.get(result, i);
                String path = (String) getPath.invoke(storageVolumeElement);
                boolean removable = (Boolean) isRemovable.invoke(storageVolumeElement);
                if (removable) {
                    return path;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dp2pxA(float dpValue) {
        final float scale = MyUtils.CONTEXT.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
    /**
     * dp转px
     */
    public static int dp2px( float dpVal)
    {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal, MyUtils.CONTEXT.getResources().getDisplayMetrics());
    }

    /**
     *sp转px
     */
    public static int sp2px(float spVal)
    {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spVal, MyUtils.CONTEXT.getResources().getDisplayMetrics());
    }

    /**
     * px转dp
     */
    public static float px2dp( float pxVal)
    {
        final float scale = MyUtils.CONTEXT.getResources().getDisplayMetrics().density;
        return (pxVal / scale);
    }

    /**
     * px转sp
     */
    public static float px2sp( float pxVal)
    {
        return (pxVal / MyUtils.CONTEXT.getResources().getDisplayMetrics().scaledDensity);
    }

    public static boolean checkPermission(String permission){
        return ContextCompat.checkSelfPermission(MyUtils.CONTEXT, permission)== PackageManager.PERMISSION_GRANTED;
    }

    /**
     * 获得屏幕宽度
     */
    public static int getScreenWidth(Context context)
    {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    /**
     * 获得屏幕高度
     *
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context)
    {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }
}
