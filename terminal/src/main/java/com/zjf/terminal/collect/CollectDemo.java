package com.zjf.terminal.collect;

import com.zjf.terminal.model.Admin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * reduce适合不可变容器归约，collect适合可变容器归约。collect适合并行。
 */
public class CollectDemo {

    private static List<Admin> admins = Arrays.asList(
            new Admin("Allen", 25),
            new Admin("Bob", 26),
            new Admin("Cache", 30),
            new Admin("Deal", 18),
            new Admin("Ella", 29),
            new Admin("Floor", 29));

    public static void main(String[] args) {
        /*
         * 直接连接
         * 结果:AllenBobCacheDealEllaFloor
         */
        System.out.println(admins.stream().map(Admin::getAdminName).collect(Collectors.joining()));
        /*
         * 逗号
         * 结果:Allen, Bob, Cache, Deal, Ella, Floor
         */
        System.out.println(admins.stream().map(Admin::getAdminName).collect(Collectors.joining(", ")));
        /*
         * 将原来的Stream映射为一个单元素流，然后收集为List。
         * 结果:[Allen, Bob, Cache, Deal, Ella, Floor]
         */
        System.out.println(admins.stream().map(Admin::getAdminName).collect(Collectors.toList()));
        /*
         * 将Type收集为一个set，可以去重复。
         * 结果:[Floor, Bob, Allen, Deal, Ella, Cache]
         */
        System.out.println(admins.stream().map(Admin::getAdminName).collect(Collectors.toSet()));
        /*
         * 分组
         */
        System.out.println(admins.stream().collect(Collectors.groupingBy(Admin::getAge)));
        /*
         * 二级分组
         */
        System.out.println(admins.stream().collect(Collectors.groupingBy(Admin::getAge, Collectors.groupingBy(Admin::getAdminName))));

        /*
         * 分区
         * 分区是分组的特殊情况：由一个谓词(返回一个布尔值的函数)作为分类函数，它称为分区函数。分区函数返回一个布尔值，这意味着得到的分组Map的键类型是Boolean，于是它最多可以分为两组：true or false.
         */
//        IntStream.rangeClosed(2, 100).boxed().collect(Collectors.partitioningBy(this::isPrime));
    }

    private boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot).noneMatch(i -> candidate % i == 0);
    }
}
