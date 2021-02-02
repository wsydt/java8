package com.wsy.java8.jdk.functional;

import com.wsy.java8.lambda.references.Car;

import java.util.Comparator;

public class ComparatorTest {

    public static void main(String[] args) {
        Comparator<Car> comparator = (c1, c2) -> c2.getBrand().compareTo(c1.getBrand());
        Car c1 = new Car("june", "pink");
        Car c2 = new Car("hey_june", "blue");

        System.out.println(comparator.compare(c1, c2));
        System.out.println(comparator.reversed().compare(c1, c2));

    }

}
