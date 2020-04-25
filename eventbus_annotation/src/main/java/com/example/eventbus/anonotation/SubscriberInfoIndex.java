package com.example.eventbus.anonotation;

import com.example.eventbus.anonotation.mode.SubscriberInfo;

/**
 * 所有的事件订阅方法，生成索引接口
 */

public interface SubscriberInfoIndex {

    /**
     * 生成索引进口，通过订阅者对象(MainActivity.class) 获取所有订阅方法
     * @param subscerberClass 订阅者对象class 如：MainActivity.class
     * @return 事件订阅方法封装
     */
    SubscriberInfo getSubscriberInfo(Class<?> subscerberClass);

}
