package com.example.android;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.ArrayMap;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

//import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View text;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getApplicationContext();

        new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                return false;
            }
        });


        ArrayMap<String, String> stringStringArrayMap = new ArrayMap<>();

//        new androidx.collection.ArrayMap<>()


        initView();
        initEvent();

        Handler handler = new Handler();

        HandlerThread hong = new HandlerThread("hong");
        Looper looper = hong.getLooper();
        hong.start();

        Looper looper1 = looper.myLooper();
        Looper mainLooper1 = Looper.getMainLooper();

        new Thread(){

            @Override
            public void run() {
                super.run();
                if (Looper.getMainLooper() == Looper.myLooper()){
                    System.out.println("=============run===");
                }else {
                    System.out.println("=============no===");
                }
            }
        }.start();


        HashMap<String, String> stringStringHashMap = new HashMap<>();

        //Glide.with(this).load("").into(new ImageView(this));

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

        // 我是dev数据
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            strings.add(i + "我是master数据");
        }

        // 我是dev数 据 新加入
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            stringArrayList.add(i + "我是master数据");
        }

        //查看冲突

    }

}
