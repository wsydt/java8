package com.wsy.java8.jdk.functional;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        Optional<String> optional = test(null);
        System.out.println(optional.isPresent());
//        System.out.println(optional.get());
        System.out.println(optional.orElse("12345"));
    }

    public static <T> Optional<T> test(T t) {
        return Optional.ofNullable(t);
    }

}
