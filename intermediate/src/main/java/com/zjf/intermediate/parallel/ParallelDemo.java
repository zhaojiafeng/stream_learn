package com.zjf.intermediate.parallel;

import com.zjf.intermediate.model.Admin;

import java.util.stream.Stream;

/**
 *
 */
public class ParallelDemo {

    public static void main(String[] args) {

        Stream.of(
                new Admin("lzj", 25),
                new Admin("zhangsan", 26),
                new Admin("lisi", 30),
                new Admin("wanger", 18),
                new Admin("zhaowu", 29),
                new Admin("zhaowu", 29))
                .parallel()
                .findAny()
                .get();

    }
}
