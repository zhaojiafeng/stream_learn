package com.zjf.intermediate.sorted;

import com.zjf.intermediate.model.Admin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
    1、sorted() 默认使用自然序排序， 其中的元素必须实现Comparable 接口
    2、sorted(Comparator<? super T> comparator) ：我们可以使用lambada 来创建一个Comparator实例。
                    可以按照升序或着降序来排序元素。
 */
public class SortedDemo {

    private static List<Admin> admins = Arrays.asList(
            new Admin(1, "azj", 25),
            new Admin(2, "hangsan", 26),
            new Admin(3, "zhaowu", 29)
    );

    public static void main(String[] args) {
        System.out.println("---Natural Sorting by Name---");
        admins.stream()
                .sorted(Comparator.comparing(Admin::getAdminName))
                .forEach(e -> System.out.println(e.toString()));

        System.out.println("---Natural Sorting by Name in reverse order---");
        admins.stream()
                .sorted(Comparator.comparing(Admin::getAdminName).reversed())
                .forEach(e -> System.out.println(e.toString()));

        System.out.println("---Sorting using Comparator by Age---");
        admins.stream()
                .sorted(Comparator.comparing(Admin::getAge))
                .forEach(e -> System.out.println(e.toString()));

        System.out.println("---Sorting using Comparator by Age with reverse order---");
        admins.stream()
                .sorted(Comparator.comparing(Admin::getAge).reversed())
                .forEach(e -> System.out.println(e.toString()));
    }
}
