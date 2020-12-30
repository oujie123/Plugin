package com.gacrnd.gcs.myplugin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        // 从自己创建的context启动
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_main, null);
        setContentView(view);
    }
}
