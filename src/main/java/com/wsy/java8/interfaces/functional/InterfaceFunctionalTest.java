package com.wsy.java8.interfaces.functional;

import com.wsy.java8.interfaces.functional.Converter;

public class InterfaceFunctionalTest {

    public static void main(String[] args) {
        //使用 lambda 表达式创建匿名实例
//        Converter<Integer, String> converter = string -> Integer.valueOf(string);
        //使用静态方法引用的方式
        Converter<Integer, String> converter = Integer::valueOf;
        int number = converter.convert("1000");
        System.out.println(number);
    }

}
