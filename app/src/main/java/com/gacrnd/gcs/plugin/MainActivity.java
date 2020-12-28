package com.gacrnd.gcs.plugin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printClassLoader();
            }
        });
    }

    private void printClassLoader() {
        ClassLoader classLoader = getClassLoader();
        while (classLoader != null) {
            Log.e("jack","classloader:" + classLoader);
            classLoader = classLoader.getParent();
        }

        Log.e("jack","Activity的classloader:" + Activity.class.getClassLoader());
        // pathClassLoader是加载应用的类 (依赖包的类，第三方库)
        // bootClassLoader是加载SDK的类
    }
}
