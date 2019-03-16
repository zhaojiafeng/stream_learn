package com.zjf.terminal.find;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
 * findFirst，返回集合的第一个对象
 * findAny返回这个集合中，取到的任何一个对象
 *
 * 在串行的流中，findAny和findFirst返回的，都是第一个对象；
 * 而在并行的流中，findAny返回的是最快处理完的那个线程的数据，所以说，在并行操作中，对数据没有顺序上的要求，那么findAny的效率会比findFirst要快的
 */
public class FindDemo {

    public static void main(String[] args) {
        List<String> strs = Arrays.asList("d", "b", "a", "c", "a");

        Optional<String> aa = strs.stream().filter(str -> !str.equals("a")).findFirst();
        Optional<String> bb = strs.stream().filter(str -> !str.equals("a")).findAny();

        Optional<String> aa1 = strs.parallelStream().filter(str -> !str.equals("a")).findFirst();
        Optional<String> bb1 = strs.parallelStream().filter(str -> !str.equals("a")).findAny();

        System.out.println(aa.get() + "===" + bb.get());// d===d
        System.out.println(aa1.get() + "===" + bb1.get());// d===b or d===c
    }
}
