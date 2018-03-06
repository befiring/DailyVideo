package com.befiring.myutils;



/**
 * Created by Wang Meng on 2017/8/24.
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static CrashHandler instance;

    public static CrashHandler getInstance() {
        if (instance == null) {
            instance = new CrashHandler();
        }
        return instance;
    }

    public void init() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {

        StringBuilder crashMsg = new StringBuilder();
        crashMsg.append(TimeUtil.getNow());
        // 错误信息
        StackTraceElement[] stackTrace = ex.getStackTrace();
        if (ex.getCause() != null) {
            stackTrace = ex.getCause().getStackTrace();
        }
        crashMsg.append(ex.getMessage());
        crashMsg.append("\n");

        for (StackTraceElement aStackTrace : stackTrace) {
            crashMsg.append("file:").append(aStackTrace.getFileName())
                    .append("class:").append(aStackTrace.getClassName())
                    .append("method:").append(aStackTrace.getMethodName())
                    .append("line:").append(aStackTrace.getLineNumber())
                    .append("\n\n");
        }
        IoUtil.writeToFileA(AppDirectory.directoryCrashLog, crashMsg.toString());

        ex.printStackTrace();
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
