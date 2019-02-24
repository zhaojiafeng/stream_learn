package com.zjf.intermediate.limit;

import com.zjf.intermediate.model.Admin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
    截断流，使流中元素不超过指定数量
 */
public class LimitDemo {

    public static void main(String[] args) {
        Stream.of(
                new Admin("lzj", 25),
                new Admin("zhangsan", 26),
                new Admin("lisi", 30),
                new Admin("wanger", 18),
                new Admin("zhaowu", 29),
                new Admin("zhaowu", 29))
                .filter((x) -> x.getAge() >= 20)
                .limit(3)
                .forEach(System.out::println);
    }
}
