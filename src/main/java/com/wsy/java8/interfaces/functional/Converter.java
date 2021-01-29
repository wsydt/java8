package com.wsy.java8.interfaces.functional;

/**
 *  函数式接口仅当只有一个抽象方法时,才可以使用 lambda 表达式,
 *  也可以添加 @FunctionalInterface 来校验程序中是否有多个抽象方法, 当大于一个时, 编译器会报错
 *
 * @param <T>
 * @param <S>
 * @author wangshuangyong 2021-01-27
 */

//@FunctionalInterface
public interface Converter<T, S> {

    T convert(S s);

//    T convert2(T t, S s);

}
