package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
    }

    private void initView(){
        text = findViewById(R.id.text);
        text.setOnClickListener(this);
        text.setVisibility(View.GONE);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "aaaa", Toast.LENGTH_SHORT).show();
            }
        });

        text.setBackgroundColor(Color.RED);
    }

    /**
     * 点击事件
     */
    private void initEvent(){

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击事件", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 我是注释
     * @param v
     */

    @Override
    public void onClick(View v) {

    }

    /**
     * 初始化数据
     */
    private void initData(){

    }

}
