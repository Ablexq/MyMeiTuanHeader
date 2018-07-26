package com.xq.meituan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xq.meituan.recyclerview.Demo2Activity;
import com.xq.meituan.gridview.Demo1Activity;

/**
 * Created by lenovo on 2018/7/26.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        findViewById(R.id.tv1).setOnClickListener(this);
        findViewById(R.id.tv2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv1:
                startActivity(new Intent(this, Demo1Activity.class));
                break;
            case R.id.tv2:
                startActivity(new Intent(this, Demo2Activity.class));
                break;
            default:
                break;
        }
    }
}
