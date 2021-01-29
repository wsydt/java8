package com.wsy.java8.interfaces;

/**
 *
 * Java 8 中,支持在接口中允许添加非抽象方法实现, 在具体的方法前添加 default 关键字.
 * 称为虚拟扩展方法
 *
 * @author wangshuangyong 2021-01-26
 */
public interface DefaultMethodForInterface {

    int calculate(int a, int b);


    default double sqrt(int number) {
        return Math.sqrt(number);
    }

}
