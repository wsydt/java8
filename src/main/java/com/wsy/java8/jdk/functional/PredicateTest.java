package com.wsy.java8.jdk.functional;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * 断言表达式 ,返回的是一个布尔值的函数, 可以进行复杂的逻辑操作,支持 and or negate 默认方法
 *
 * @author wangshuangyong 2021-01-29
 */
public class PredicateTest {

    public static void main(String[] args) {

        Predicate<String> predicate = s -> s.length() > 0;
        System.out.println(predicate.test("342"));

        Predicate<String> predicate1 = Objects::isNull;
//        System.out.println(predicate1.and(predicate).test(null));
        System.out.println(predicate1.or(predicate).test("2"));


    }

}
