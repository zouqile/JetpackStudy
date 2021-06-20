package com.example.jetpackdemo;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zql on 2018-08-05.
 */

public class ThreadUtil {
    private static Handler mainHandler = new Handler(Looper.getMainLooper());
    private static ExecutorService mCachedThreadPool = Executors.newCachedThreadPool();
    public static void main(Runnable runnable) {
        if (isMainThread()) {
            runnable.run();
            return;
        }
        mainHandler.post(runnable);
    }
    public static void main(Runnable runnable, int delayMillisecond) {
        mainHandler.postDelayed(runnable,delayMillisecond);
    }

    public static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void thread(Runnable runnable) {
        mCachedThreadPool.submit(runnable);
    }

}
