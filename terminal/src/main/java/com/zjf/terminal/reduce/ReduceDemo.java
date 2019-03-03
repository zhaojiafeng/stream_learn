package com.zjf.terminal.reduce;

import com.zjf.terminal.model.Admin;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.reducing;

/*
 * 上面代码例如第一个示例的 reduce()，第一个参数（空白字符）即为起始值，第二个参数（String::concat）为 BinaryOperator。
 * 这类有起始值的 reduce() 都返回具体的对象。而对于第四个示例没有起始值的 reduce()，由于可能没有足够的元素，返回的是 Optional，请留意这个区别。
 */
public class ReduceDemo {

    private static List<Admin> admins = Arrays.asList(
            new Admin(1, "azj", 25),
            new Admin(2, "hangsan", 26),
            new Admin(3, "zhaowu", 29)
    );

    public static void main(String[] args) {
        /*
         * 字符串连接
         * 结果： ABCD
         */
        System.out.println(Stream.of("A", "B", "C", "D").reduce("", String::concat));
        /*
         * 求最小值
         * 结果：-3.0
         */
        System.out.println(Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min));
        /*
         * 求和
         * 结果：10
         */
        System.out.println(Stream.of(1, 2, 3, 4).reduce(0, Integer::sum));
        /*
         *  求和，无起始值
         *  结果：10
         */
        System.out.println(Stream.of(1, 2, 3, 4).reduce(Integer::sum).get());
        /*
         *  过滤，字符串连接
         *  结果：ace
         */
        System.out.println(Stream.of("a", "B", "c", "D", "e", "F").filter(x -> x.compareTo("Z") > 0).reduce("", String::concat));
        /*
         * 可以用来求和
         */
        Integer totalCalories = admins.stream().collect(reducing(0, Admin::getAge, (i, j) -> i + j));
        Integer totalCalories2 = admins.stream().collect(reducing(0, Admin::getAge, Integer::sum));  //使用内置函数代替箭头函数
        Integer totalCalories3 = admins.stream().map(Admin::getAge).reduce(Integer::sum).orElse(0);
        //虽然都可以，但考量效率的话，还是要选择下面这种
        int sum = admins.stream().mapToInt(Admin::getAge).sum();
    }
}
