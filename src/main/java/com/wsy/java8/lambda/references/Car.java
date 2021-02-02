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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
