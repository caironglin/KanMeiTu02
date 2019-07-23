package com.rl.kanmeitu02.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.r0adkll.slidr.Slidr;
import com.rl.kanmeitu02.R;
import com.rl.kanmeitu02.ui.fragment.SettingFragment;

/**
 * 描述：设置的Activity
 *
 * @author jay on 2018/1/12 14:01
 */

public class SettingActivity extends AppCompatActivity{

    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Slidr.attach(this);
        initData();
        initView();
    }

    private void initData() {

    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("设置");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(view -> finish());

        getSupportFragmentManager().beginTransaction().replace(R.id.cly_root, SettingFragment.newInstance()).commit();

    }

}
