package com.wsy.java8.jdk.functional;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        Optional<String> optional = test("hey_june");
        System.out.println(optional.isPresent());
//        System.out.println(optional.get());
        System.out.println(optional.orElse("12345"));
        optional.ifPresent((s) -> {
            if (s == null || s.trim().length() == 0) {
                System.out.println("june");
            } else {
                System.out.println(s);
            }
        });
    }

    public static <T> Optional<T> test(T t) {
        return Optional.ofNullable(t);
    }

}
