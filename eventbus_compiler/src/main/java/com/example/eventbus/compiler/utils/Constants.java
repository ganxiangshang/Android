package com.example.eventbus.compiler.utils;

public class Constants {

    //注解处理器中支持的注解类型
    public static final String SUBSCRIBE_ANNOTATION_TYPES = "com.example.eventbus.anonotation.Subscribe";

    //APT生成类文件所属包名
    public static final String PACKAGE_NAME = "packageName";

    //APT生成类文件中的类名
    public static final String CLASS_NAME = "className";

    //所有的事件订阅方法，生成索引接口
    public static final String SUBSCRIBERINFO_INDEX = "com.example.eventbus.anonotation.SubscriberInfoIndex";

    //全局属性名
    public static final String FIELD_NAME = "SUBSCRIBER_INDEX";

    //putIndex方法的参数对象名
    public static final String PUTINDEX_PARAMETER_NAME = "info";

    //加入Map集合方法名
    public static final String PUTINDEX_METHOD_NAME = "putIndex";

    //getSubscriberINfo方法的参数对象名
    public static final String GETSUBSCRIBERINFO_PARAMETER_NAME = "subscriberClass";

    //通过订阅者(MainActivity.class)获取所有订阅方法的方法名
    public static final String GETSUBSCRIBERINFO_METHOD_NAME = "getSubscriberInfo";


}
