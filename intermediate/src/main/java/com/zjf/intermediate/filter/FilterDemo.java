package com.zjf.intermediate.filter;

import com.zjf.intermediate.model.Admin;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;

/*
    filter从通道流中按自定义的规则过滤出满足条件的序列。
 */
public class FilterDemo {

    public static void main(String[] args) {
        // 获取年龄大于20的用户。
        Stream<Admin> stream = Stream.of(
                new Admin("lzj", 25), new Admin("zhangsan", 26),
                new Admin("lisi", 30), new Admin("wanger", 18),
                new Admin("zhaowu", 29), new Admin("zhaowu", 29))
                .filter((x) -> x.getAge() > 20);
        /*方法一：*/
        Consumer<Admin> consumer = System.out::println;
        stream.forEach(consumer);
        /*方法二：*/
        stream.forEach(System.out::println);


        //把单词挑出来
//        List<String> output = reader.lines()
//                .flatMap(line -> Stream.of(line.split(REGEXP)))
//                .filter(word -> word.length() > 0)
//                .collect(Collectors.toList());

        //这段代码首先把每行的单词用 flatMap 整理到新的 Stream，然后保留长度不为 0 的，就是整篇文章中的全部单词了。
    }
}
