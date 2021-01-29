package com.wsy.java8.interfaces;

import com.wsy.java8.interfaces.DefaultMethodForInterface;

public class DefaultMethodTest {

    public static void main(String[] args) {

        DefaultMethodForInterface defaultMethodForInterface = new DefaultMethodForInterface(){

            @Override
            public int calculate(int a, int b) {
                return a + b * b;
            }

            /**
             * 接口中的非抽象方法也支持被重载
             */
            @Override
            public double sqrt(int number) {
                return Math.sqrt(number) + 10;
            }
        };

        System.out.println(defaultMethodForInterface.calculate(5, 8));
        System.out.println(defaultMethodForInterface.sqrt(81));


    }

}
