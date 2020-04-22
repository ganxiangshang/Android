package com.hong.kotlin_lib


fun main(){

    println("HelloWorld")
    var simpleClass = SimpleClass(2)
    println(simpleClass.x)
    simpleClass.log()

    //? 表示可以为空
    var str: String? = null
//    str = "hello"
    // ?: 表示 如果str?.length = null,返回0
    var length = str?.length ?: 0
    println(length)

    Singleton.y()

    Foo.x

}

