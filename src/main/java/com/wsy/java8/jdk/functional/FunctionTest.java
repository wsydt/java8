package com.wsy.java8.jdk.functional;

import java.util.function.Function;

/**
 * Function<T, R> 输入类型 T 参数, 返回 R 类型结果
 *
 * 1. andThen方法, apply(t) 返回值是类型 R, 所以Function after可以接受的输入参数为R的所有父类类型(? super R),
 *    新的Function 方法返回的是一个新的类型V(包括类型 V 的子类).
 *    返回的是输入类型 T 返回类型 V 的Function<T, V>
 * <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
 *         Objects.requireNonNull(after);
 *         return (T t) -> after.apply(apply(t));
 *     }
 *
 * 2. compost方法, 当前 apply(T t) 接受的是 T 类型的参数,
 *    所以 Function before 是输入 V 类型参数(包类型 V 的所有父类类型), 返回 T 类型结果.
 *    最后返回的Function<V, R> 是一个输入类型 V ,返回结果为类型 R 的 Function
 * <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
 *         Objects.requireNonNull(before);
 *         return (V v) -> apply(before.apply(v));
 *     }
 *
 * @author wangshuangyong 2021-01-29
 */
public class FunctionTest {

    public static void main(String[] args) {
        Function<Integer, String> function = String::valueOf;
        Function<Object, Double> function1 = obj -> Double.parseDouble(obj.toString());
        System.out.println(function.andThen(function1).apply(501).getClass());
//        System.out.println(function.compose(function1).apply(501).getClass());

//        System.out.println(function1.andThen(function).apply(501).getClass());
        System.out.println(function1.compose(function).apply(501).getClass());


        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        System.out.println(backToString.apply("123"));
    }

}
