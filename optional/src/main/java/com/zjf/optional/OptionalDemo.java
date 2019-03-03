package com.zjf.optional;

import com.zjf.model.Admin;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 返回Optional原因： 如果stream为null怎么办, 这时候Optinal就很有意义了
 */
public class OptionalDemo {

    private static List<Admin> admins = Arrays.asList(
            new Admin("Allen", 25),
            new Admin("Bob", 26),
            new Admin("Cache", 30),
            new Admin("Deal", 18),
            new Admin("Ella", 29),
            new Admin("Floor", 29));

    public static void main(String[] args) {
        Optional<Admin> maxAge = admins.stream().max(Comparator.comparingInt(Admin::getAge));
        Optional<Admin> minAge = admins.stream().min(Comparator.comparingInt(Admin::getAge));
        Double avgCalories = admins.stream().collect(Collectors.averagingInt(Admin::getAge));

        IntSummaryStatistics summaryStatistics = admins.stream().collect(Collectors.summarizingInt(Admin::getAge));
        double average = summaryStatistics.getAverage();
        long count = summaryStatistics.getCount();
        int max = summaryStatistics.getMax();
        int min = summaryStatistics.getMin();
        long sum = summaryStatistics.getSum();
    }
}
