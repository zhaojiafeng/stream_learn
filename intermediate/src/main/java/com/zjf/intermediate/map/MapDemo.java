package com.zjf.intermediate.map;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * map（mapToInt, flatMap 等）用来归类，结果一般是一组数据。比如可以将list中的学生分数映射到一个新的stream中。
 * map 进行对于Stream中包含的元素使用给定的转换函数进行转换操作
 */
public class MapDemo {

    public static void main(String[] args) {
        // 转换大写
        Stream.of("Allen", "Bob", "Cache", "Deal")
                .map(String::toUpperCase)
                .forEach(System.out::print);
        System.out.println("---------");

        // 获取平方数
        Stream.of(1, 2, 3, 4)
                .map(n -> n * n)
                .forEach(System.out::print);
        /*  结果：
                1 4 9 16
         */
        System.out.println("---------");

        //一对多
        Stream.of(Collections.singletonList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6))
                .flatMap(Collection::stream)
                .forEach(System.out::print);
        //flatMap是一对多映射关系 。
        // flatMap 把 inputStream 中的层级结构扁平化，就是将最底层元素抽出来放到一起，
        // 最终的新 Stream 里面已经没有 List 了，都是直接的数字，即{1,2,3,4,5,6}。
    }
}
