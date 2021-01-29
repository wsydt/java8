package com.wsy.java8.lambda;

import com.wsy.java8.lambda.LambdaExpressions;

import java.util.ArrayList;
import java.util.List;

public class LambdaExpressionsTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Anna");
        list.add("Mercy");
        list.add("Tracer");
        list.add("June");

        LambdaExpressions lambdaExpressions = new LambdaExpressions(list);
        lambdaExpressions.sort();
        lambdaExpressions.print();

    }

}
