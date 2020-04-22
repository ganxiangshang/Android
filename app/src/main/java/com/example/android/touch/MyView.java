package com.example.android.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MyView extends androidx.appcompat.widget.AppCompatTextView {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        boolean b = super.dispatchTouchEvent(event);
        System.out.println("========MyView===dispatchTouchEvent====" + b);
        return b;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("========MyView===onTouchEvent====");
        int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN){
            System.out.println("========MyView===onTouchEvent==ACTION_DOWN==");
        }else if (action == MotionEvent.ACTION_UP){
            System.out.println("========MyView===onTouchEvent===ACTION_UP=");
        }else if (action == MotionEvent.ACTION_CANCEL){
            System.out.println("========MyView===onTouchEvent==ACTION_CANCEL==");
        }else if (action == MotionEvent.ACTION_MOVE){
            System.out.println("========MyView===onTouchEvent==ACTION_MOVE==");
        }
        return super.onTouchEvent(event);
    }
}
