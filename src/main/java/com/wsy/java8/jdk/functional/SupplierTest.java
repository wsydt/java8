package com.wsy.java8.jdk.functional;

import com.wsy.java8.lambda.references.Car;

import java.util.function.Supplier;

/**
 * Supplier 返回一个通用的类型的结果, 不接受任何参数.
 *    T get():
 * @author wangshuangyong 2021-01-29
 */
public class SupplierTest {

    public static void main(String[] args) {
        Supplier<Car> supplier = Car::new;

        System.out.println(supplier.get());
    }

}
