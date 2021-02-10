package com.wsy.java8.annotations;


import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@Repeatable(Hints.class)
public @interface Hint {

    String value();

}
