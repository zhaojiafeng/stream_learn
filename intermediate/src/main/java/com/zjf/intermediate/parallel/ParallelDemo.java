package com.zjf.intermediate.parallel;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

/**
 * parallelStream执行效率要比传统的for循环和stream要快的多，
 * 那么什么时候要用stream或者parallelStream呢？可以从以下三点入手考虑
 * <p>
 * 1、是否需要并行？
 * 2、任务之间是否是独立的？是否会引起任何竞态条件？
 * 3、结果是否取决于任务的调用顺序？
 */
public class ParallelDemo {

    public static void main(String[] args) {
        //所有数字都是随机输出，即每次的输出结果都不一样
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.forEach(System.out::println);
        numbers.parallelStream().forEach(out::println);
        numbers.parallelStream().forEachOrdered(System.out :: println);

        // parallelStream每次执行的结果都不相同，与多线程程序中执行的结果类似。

        // parallelStream背后的男人:ForkJoinPool
    }
}
