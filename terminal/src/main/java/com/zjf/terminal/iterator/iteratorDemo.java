package com.zjf.terminal.iterator;

import java.util.stream.Stream;

/*
 * treamList = demoList.stream().map(demo -> demo.getIndex()).collect(Collectors.toList());
 */
public class iteratorDemo {

    public static void main(String[] args) {

    //    清单 24. 生成一个等差数列
//        Stream.iterate(0, n -> n + 3)
//                .limit(10)
//                .forEach(x -> System.out.print(x + " "));
    }

//    输出结果：
//            0 3 6 9 12 15 18 21 24 27
//
//    与 Stream.generate 相仿，在 iterate 时候管道必须有 limit 这样的操作来限制 Stream 大小。
//    进阶：用 Collectors 来进行 reduction 操作
//    java.util.stream.Collectors 类的主要作用就是辅助进行各类有用的 reduction 操作，例如转变输出为 Collection，把 Stream 元素进行归组。
//    groupingBy/partitioningBy
}
