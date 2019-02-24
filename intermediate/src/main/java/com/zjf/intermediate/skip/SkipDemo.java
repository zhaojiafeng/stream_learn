package com.zjf.intermediate.skip;

import com.zjf.intermediate.model.Admin;

import java.util.Arrays;
import java.util.List;

/*
    skip 跳过流中指定个数的序列
 */
public class SkipDemo {

    // 跳过  XXX 个元素
    private static List<Admin> admins = Arrays.asList(
            new Admin("lzj", 25),
            new Admin("zhangsan", 26),
            new Admin("lisi", 30),
            new Admin("wanger", 18),
            new Admin("zhaowu", 29),
            new Admin("zhaowu", 29)
    );

    public static void main(String[] args) {
        admins.stream()
                .filter((x) -> x.getAge() >= 20)
                .skip(2)
                .forEach(System.out::println);
    }
}
