package com.wsy.java8.jdk.functional;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Map 不支持stream, Map 接口中也不存在 stream() 方法,
 * 但是可以在 map 的 key, value, entry 上使用 stream() 方法,
 *  map.keySet().stream(), map.values().stream(), map.entrySet().stream()
 *
 * @author wangshuangyong 2021-02-01
 */
public class MapTest {

    public static void main(String[] args) {
        Map<Integer, String> map = initMap();
        // putIfAbsent 方法可以在 put 之前进行 null 判断, 不存在 key 才可以 put
        map.putIfAbsent(3,"june");
//        map.entrySet().forEach(System.out::println);
        //compute
        //computeIfPresent, 如果存在当前key, 当前 key和 value 按照指定方法生成一个新的value,
        // 替换旧的 value 并且返回新的 value,
        // 不存在 key 返回 null
        map.computeIfPresent(4, (key, value) -> key + "_" + value);
        //computeIfAbsent, 如果不存在 key, 则当前 key 按照指定方法生成新的 value,
        //put key和 value,并且返回这个value,
        // 如果存在 key, 则直接返回key对应的value
        map.computeIfAbsent(42, key -> key + " june birthday");
        // 移除指定 key 和 value 的键值对, key 和 value 都要相等.
        map.remove(5, "value5");
        map.remove(6, "value");
//        map.entrySet().forEach(System.out::println);
        //获取一个指定key的value, 如果 key 不存在, 则返回一个默认值.
        System.out.println(map.getOrDefault(402, "miss U"));

        // 合并指定 key 的值
        // 如果 key 为 null, 则将当前 key 和 value 添加到 map 中
        // 如果 key 不为 null, 则取出旧的 value, 和传入的 value 一起按照指定方法生成新的 value, 并且更新当前map的key,返回新的 value.
        System.out.println(map.merge(93, "wsy ", String::concat));
        System.out.println(map.merge(93, "miss ", String::concat));
        System.out.println(map.merge(93, "tdy ", String::concat));
        map.entrySet().forEach(System.out::println);
    }

    private static Map<Integer, String> initMap() {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i ++) {
            map.put(i, "value" + i);
        }
        return map;
    }

}
