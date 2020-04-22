package com.example.android.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class ViewGroupB extends LinearLayout {

    public ViewGroupB(Context context) {
        super(context);
    }

    public ViewGroupB(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewGroupB(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        System.out.println("========ViewGroupB===onInterceptTouchEvent====");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        boolean b = super.dispatchTouchEvent(event);
        System.out.println("========ViewGroupB===dispatchTouchEvent====" + b);
        return b;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        System.out.println("========ViewGroupB===onTouchEvent====");
        int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN){
            System.out.println("========ViewGroupB===onTouchEvent==ACTION_DOWN==");
        }else if (action == MotionEvent.ACTION_UP){
            System.out.println("========ViewGroupB===onTouchEvent===ACTION_UP=");
        }else if (action == MotionEvent.ACTION_CANCEL){
            System.out.println("========ViewGroupB===onTouchEvent==ACTION_CANCEL==");
        }
        return super.onTouchEvent(event);
    }


}
