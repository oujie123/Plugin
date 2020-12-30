package com.gacrnd.gcs.myplugin;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;

/**
 * @author Jack_Ou  created on 2020/12/30.
 */
public class BaseActivity extends AppCompatActivity {

    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Resources resources = LoadUtil.getResources(getApplication());

        mContext = new ContextThemeWrapper(getBaseContext(), 0);

        Class<? extends Context> aClass = mContext.getClass();
        try {
            Field mResourcesField = aClass.getDeclaredField("mResources");
            mResourcesField.setAccessible(true);
            mResourcesField.set(mContext,resources);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 该问题方案会报resId冲突导致空指针异常
     *
     * @return
     */
//    @Override
//    public Resources getResources() {
//        // 宿主设置了Resources
////        if (getApplication() != null && getApplication().getResources()!=null) {
////            return getApplication().getResources();
////        }
//        Resources resources = LoadUtil.getResources(getApplication());
//        return resources == null ? super.getResources() : resources;
//    }
}
