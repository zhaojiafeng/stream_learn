package com.zjf.terminal.match;

import com.zjf.terminal.model.Admin;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
 * anyMatch表示，判断的条件里，任意一个元素成功，返回true
 * allMatch表示，判断条件里的元素，所有的都是，返回true
 * noneMatch跟allMatch相反，判断条件里的元素，所有的都不是，返回true
 */
public class MatchDemo {

    public static void main(String[] args) {

        List<Admin> adminStream = Arrays.asList(
                new Admin(1, "name" + 1, 10), new Admin(2, "name" + 2, 21),
                new Admin(3, "name" + 3, 34), new Admin(4, "name" + 4, 6),
                new Admin(5, "name" + 5, 55), new Admin(6, "name" + 6, 17)
        );

        boolean isAllAdult = adminStream.stream().allMatch(p -> p.getAge() > 18);
        System.out.println("All are adult? " + isAllAdult);
        boolean isThereAnyChild = adminStream.stream().anyMatch(p -> p.getAge() < 12);
        System.out.println("Any child? " + isThereAnyChild);
        boolean isThereNoChild = adminStream.stream().noneMatch(p -> p.getAge() < 18);
        System.out.println("Has child? " + isThereNoChild);
        /*
            输出结果：
                All are adult? false
                Any child? true
                Has child? false
         */
    }
}
