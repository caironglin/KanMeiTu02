package com.rl.kanmeitu02.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.rl.kanmeitu02.R;

/**
 * 描述：闪屏页
 *
 * @author CoderPig on 2018/02/13 15:23.
 */

public class SplashActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TextView tv_logo = findViewById(R.id.tv_logo);
        tv_logo.postDelayed(this::jump,500L);

    }

    /* 完成一些初始化操作 */
    private void init() {

    }

    /* 页面逻辑跳转 */
    private void jump() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

}
