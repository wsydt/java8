package com.wsy.java8.jdk.functional;

import com.wsy.java8.lambda.references.Car;

import java.util.function.Consumer;

/**
 *  Consumer 对单个输入参数执行相应的操作, 不返回任何结果
 *   accept(T t);
 * @author wangshuangyong 2021-01-29
 */
public class ConsumerTest {

    public static void main(String[] args) {
        Consumer<Car> consumer = car -> System.out.println(car.toString());
        Car car = new Car("Toyota", "green");
        consumer.accept(car);
    }

}
