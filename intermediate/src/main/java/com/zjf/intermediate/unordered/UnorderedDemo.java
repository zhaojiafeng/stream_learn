package com.zjf.intermediate.unordered;

import java.util.stream.Stream;

/**
 * unordered 操作不会进行任何显式的打乱流的操作。
 * 工作：消除流中必须保持的有序约束，因此允许之后的操作使用 不必考虑有序的优化。
 */
public class UnorderedDemo {

    public static void main(String[] args) {
        Stream.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17)
                .unordered()
                .forEach(System.out::println);
    }
}
