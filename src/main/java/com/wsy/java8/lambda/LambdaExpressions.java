package com.wsy.java8.lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 *
 * Lambda 表达式使用...
 *
 * @author wangshuangyong 2021-01-26
 */

public class LambdaExpressions {

    private List<String> list;

    public LambdaExpressions() {

    }

    public LambdaExpressions(List<String> list) {
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void sort(){
        if (list != null) {

            //list排序使用创建Comparator匿名内部类方式进行排序
//            Collections.sort(list, new Comparator<String>() {
//                @Override
//                public int compare(String o1, String o2) {
//                    return o1.compareTo(o2);
//                }
//            });
//
            //使用lambda表达式创建匿名内部类
//            Collections.sort(list, (String a, String b) -> {
//                return a.compareTo(b);
//            });
//
            // 方法内部只有一条代码,所以去掉{} 和 return ,改成下面语句形式
//            list.sort((a, b) -> a.compareTo(b));

            //直接使用 Comparator 实现类方法
            list.sort(String::compareTo);
        }
    }

    public void print(){
        System.out.println(list);
    }

}
