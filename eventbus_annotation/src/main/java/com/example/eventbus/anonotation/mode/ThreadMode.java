package com.example.eventbus.anonotation.mode;

public enum ThreadMode {

    //订阅，发布同一线程
    POSTING,

    //主线程（UI线程）中被调用，切勿耗时操作
    MAIN,

    //用于网络访问等耗时操作，事件总线已完成的异步订阅通知线程。并使用线程池有效地重用
    ASYNC


}
