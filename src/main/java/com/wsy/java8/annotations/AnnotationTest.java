package com.wsy.java8.annotations;

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class AnnotationTest {

    public static void main(String[] args) {

        Hint hints = Person.class.getAnnotation(Hint.class);
        System.out.println(hints);

        Hints[] hints1 = Person.class.getAnnotationsByType(Hints.class);
        System.out.println(Arrays.toString(hints1));

        Hint[] hintNews = PersonNew.class.getAnnotationsByType(Hint.class);
        System.out.println(Arrays.toString(hintNews));

        Hints[] hintNews1 = PersonNew.class.getAnnotationsByType(Hints.class);
        System.out.println(Arrays.toString(hintNews1));

        Annotation[] annotations = Person.class.getAnnotations();
        System.out.println(Arrays.toString(annotations));

    }

}
