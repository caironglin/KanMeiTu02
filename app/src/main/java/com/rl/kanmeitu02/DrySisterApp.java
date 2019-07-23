package com.rl.kanmeitu02;

import android.app.Application;
import android.content.Context;

import com.rl.kanmeitu02.utils.CrashHandler;

/**
 * 描述：Application类,单例模式来源
 *
 */
public class DrySisterApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
//        CrashHandler.getInstance().init(this); // 调试阶段不输出到文件中
    }

    public static DrySisterApp getContext() {
        return (DrySisterApp) context;
    }
}
