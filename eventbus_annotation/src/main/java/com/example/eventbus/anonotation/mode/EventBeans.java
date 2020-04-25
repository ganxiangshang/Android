package com.example.eventbus.anonotation.mode;

public class EventBeans implements SubscriberInfo{

    //订阅者对象Class,如：MainActivity.class
    private final Class subscriberClass;

    //订阅方法数组
    private final SubscriberMethod[] methodInfos;

    public EventBeans(Class subscriberClass, SubscriberMethod[] methodInfos) {
        this.subscriberClass = subscriberClass;
        this.methodInfos = methodInfos;
    }

    @Override
    public Class<?> getSubscriberClass() {
        return subscriberClass;
    }

    @Override
    public SubscriberMethod[] getSubscriberMethod() {
        return methodInfos;
    }
}
