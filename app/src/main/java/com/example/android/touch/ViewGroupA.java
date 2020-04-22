package com.example.android.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class ViewGroupA extends ScrollView {

    public ViewGroupA(Context context) {
        super(context);
    }

    public ViewGroupA(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ViewGroupA(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean b = super.onInterceptTouchEvent(ev);
        System.out.println("========ViewGroupA===onInterceptTouchEvent====" + b);
        return b;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        boolean b = super.dispatchTouchEvent(event);
        System.out.println("========ViewGroupA===dispatchTouchEvent====" + b);
        return b;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //System.out.println("========ViewGroupA===onTouchEvent====");
        int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN){
            System.out.println("========ViewGroupA===onTouchEvent==ACTION_DOWN==");
        }else if (action == MotionEvent.ACTION_UP){
            System.out.println("========ViewGroupA===onTouchEvent===ACTION_UP=");
        }else if (action == MotionEvent.ACTION_CANCEL){
            System.out.println("========ViewGroupA===onTouchEvent==ACTION_CANCEL==");
        }else if (action == MotionEvent.ACTION_MOVE){
//            System.out.println("========ViewGroupA===onTouchEvent==ACTION_MOVE==");
        }
        return super.onTouchEvent(event);
    }




}
