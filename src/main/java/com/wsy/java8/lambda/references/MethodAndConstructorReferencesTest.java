package com.wsy.java8.lambda.references;

/**
 *  引用使用 :: 关键字
 *
 * @author wangshuangyong 2021-01-29
 */
public class MethodAndConstructorReferencesTest {

    public static void main(String[] args ){
        //使用构造器引用, 不需要手动实现实例工厂, 引用会收集所有的构造器, 并且匹配签名选择一个最合适的构造器
        CarFactory<Car> factory = Car::new;
        Car car = factory.create("Toyota", "red");
        System.out.println(car);

        //使用静态方法引用
        WarrantyCalculator<Integer> calculator1 = Car::warrantyPeriod;
        int result1 = calculator1.calculate(789);
        System.out.println(result1);

        //实例方法引用
        WarrantyCalculator<Integer> calculator2 = car::distance;
        int result2 = calculator2.calculate(789);
        System.out.println(result2);
    }

}
