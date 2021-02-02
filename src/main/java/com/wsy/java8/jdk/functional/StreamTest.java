package com.wsy.java8.jdk.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Stream  方法练习
 * Stream 表示可以执行一个或多个操作的一系列元素, 流操作是中间操作和终端操作
 *   中间操作返回流本身,因此可以在一行中链接多个方法调用 终端操作返回某种类型的结果
 * Stream 是在 Source 上创建的, 例如 List 和 Set,(不支持Map)
 * 流操作可以顺序执行也可以并行执行
 *
 * Stream: 流操作产生的结果, 不会修改源数据
 *      不存储数据: 通过计算操作的管道, 从数据源中传递元素
 *      中间操作从是 lazy 的,
 *      Stream 没有大小限制, e.g. limit(n) 或者 findFirst() 这样的短路操作允许有限时间内完成无限流的计算
 *
 * Stream 原理：AbstractPipeline 是抽象管道类, StreamSupport是流的低级工具类
 *      使用 stage 来抽象每一个流水线操作，每一个 stage 就是一个 Stream, 是 AbstractPipeline 子类的内部子类, Head, StatelessOp, StatefulOp.
 *      StreamSupport 创建生成的 Stream 对应的是 Head 类，
 *      中间操作分为有状态的和无状态的, 使用 filter, map 等返回的是 StatelessOp 或者是 StatefulOp, 多个 Stage 组合成为双向链表, 组成整个流水线
 *      流水线中相邻的两个操作使用 Sink 来协调计算运行。
 *      Sink 的模式是 begin accept end 还有短路标记。 accept 中封装了回调方法。
 *      在每一个操作 Stage StatelessOp StatefulOp 中封装了 Sink。
 *      可以通过 AbstractPipeline 中提供的 opWrapSink 方法可以获取到这个 Sink, 调用当前 Sink 的 accept 方法就可以调用当前操作的方法。
 *      opWrapSink 方法接收一个 Sink 作为参数, 调用 accept 方法时, 可以调用这个入参的 Sink 的 accept 方法, 这样就可以调用下一个 Stage 的 accept。
 *
 *      找到开始的 Stage, 这样就可以顺序完成所有的中间操作。
 *      终端操作就会执行并且得到最后的结果
 *
 * @author wangshuangyong 2021-02-01
 */
public class StreamTest {

    public static void main(String[] args) {
        List<String> list = getListData();
        //filter
        list.stream().filter(s -> s.contains("e")).filter(s -> s.contains("j")).limit(2).forEach(System.out::println);
        System.out.println("-----------------------split--------------------------");
        //sorted
        list.stream().filter(s -> s.contains("y")).sorted().forEach(s -> System.out.print(s + "\t\t"));
        System.out.println();
        System.out.println();
        System.out.println("-----------------------split--------------------------");
        list.forEach(s -> System.out.print(s + "\t\t"));
        System.out.println();
        System.out.println("-----------------------split--------------------------");
        //map
        list.stream().filter(s -> s.contains("y")).map(String::toUpperCase).forEach(s -> System.out.print(s + "\t\t"));
        System.out.println();
        //match
        System.out.println("-----------------------split--------------------------");
        boolean anyMatch = list.stream().anyMatch(s -> s.startsWith("j"));
        System.out.println(anyMatch);
        boolean allMatch = list.stream().allMatch(s -> s.startsWith("j"));
        System.out.println(allMatch);
        boolean noneMatch = list.stream().noneMatch(s -> s.startsWith("j"));
        System.out.println(noneMatch);
        //count
        System.out.println("-----------------------split--------------------------");
        long count = list.stream().filter(s -> s.contains("d")).count();
        System.out.println("count : " + count);
        //reduce
        System.out.println("-----------------------split--------------------------");
        Optional<String> optional = list.stream().filter(s -> s.contains("hey")).reduce((s1, s2) -> s1 + "#" + s2);
        optional.ifPresent(System.out::println);



    }

    private static List<String> getListData() {
        List<String> list = new ArrayList<>();
        list.add("june");
        list.add("hey_june");
        list.add("july");
        list.add("hey_july");
        list.add("may");
        list.add("hey_may");
        list.add("tdy");
        list.add("hey_tdy");
        return list;
    }

}
