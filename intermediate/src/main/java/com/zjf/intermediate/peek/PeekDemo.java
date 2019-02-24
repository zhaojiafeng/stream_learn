package com.zjf.intermediate.peek;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*
    peek 接收一个没有返回值的λ表达式，可以做一些输出，外部处理等。
    map  接收一个有返回值的λ表达式，之后Stream的泛型类型将转换为map参数λ表达式返回的类型
 */
public class PeekDemo {

    public static void main(String[] args) {
        List list = new ArrayList();
        Stream.of("aa", "ss", "dd", "ff", "gg", "hh")
                .peek(e-> System.out.println(e.toUpperCase()))
                .forEach(list::add);                // 即为：.forEach(e ->list.add(e));
        System.out.println(list);
    }
}
