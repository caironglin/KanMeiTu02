package com.rl.kanmeitu02;

import android.app.Application;
import android.content.Context;

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
    }

    public static DrySisterApp getContext() {
        return (DrySisterApp) context;
    }
}
