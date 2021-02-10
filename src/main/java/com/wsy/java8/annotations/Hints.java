package com.wsy.java8.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //注解的生命周期， RunTime，保留在运行时期； Class 默认，保留在class文件中，重新加载不到； Source 保留在编译阶段
@Target(ElementType.TYPE)
public @interface Hints {
    Hint[] value();

}
