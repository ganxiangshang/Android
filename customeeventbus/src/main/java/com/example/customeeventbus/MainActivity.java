package com.example.customeeventbus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.customeeventbus.model.UserInfo;
import com.example.eventbus.anonotation.Subscribe;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Subscribe
    public void onEvent(UserInfo user){
        System.out.println("===========user==" + user.toString());
    }


}
