package com.wsy.java8.lambda.references;

public class Car {

    private String brand;

    private String color;

    public Car(){

    }

    public Car (String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    public int distance(int time) {
        return time * 100;
    }

    public static int warrantyPeriod(int time) {
        return time << 2;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
