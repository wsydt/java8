package com.wsy.java8.lambda.references;

public interface CarFactory<C extends Car> {

    C create(String brand, String color);

}
