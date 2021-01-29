package com.wsy.java8.lambda.scope;

import com.wsy.java8.interfaces.functional.Converter;

/**
 * 局部变量 (innerNumber) :
 * Lambda 表达式可以访问外部的 final 类型的变量
 * 申明的变量也不是必须要定义成 final 类型,
 * 但是访问的这个变量必须是隐式的 final 类型(就是说这个变量 禁止被写入[没有代码写入这个变量])
 *
 * 类的成员变量和静态变量:
 * Lambda 表达式内部支持访问和修改
 *
 * @author wangshuangyong 2021-01-27
 */
public class LambdaScope {

    int outNumber;

    static int outStaticNumber;

    public void initConverter() {
        int innerNumber = 20;
        // 变量被写入 编译报错
//        innerNumber = 30;
        Converter<Integer, String> converter1 = string -> {
            //Lambda 表达式内部写入变量 编译报错.
//            innerNumber = 20;
            outNumber += innerNumber;
            outStaticNumber = 10;
            return Integer.valueOf(string);
        };
        // 变量被写入 编译报错
//        innerNumber = 99;
        outNumber = 4;
        outStaticNumber = 90;
        Converter<String, Integer> converter2 = integer -> {
            outNumber = 9;
            outStaticNumber = 10;
            return String.valueOf(integer);
        };
        outNumber = 5;
        outStaticNumber = 8989;
    }



}
