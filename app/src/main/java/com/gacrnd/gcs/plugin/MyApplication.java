package com.gacrnd.gcs.plugin;

import android.app.Application;
import android.content.res.Resources;

/**
 * @author Jack_Ou  created on 2020/12/30.
 */
public class MyApplication extends Application {

//    private Resources mResources;

    @Override
    public void onCreate() {
        super.onCreate();
        LoadUtil.loadClass(this);
//        mResources = LoadUtil.loadResource(this);

        HookUtil.hookAMS();
        HookUtil.hookHandler();
    }
//
//    @Override
//    public Resources getResources() {
//        return mResources == null ? super.getResources() : mResources;
//    }
}
