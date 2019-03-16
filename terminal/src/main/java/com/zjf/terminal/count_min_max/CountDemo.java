package com.zjf.terminal.count_min_max;

import com.zjf.terminal.model.Admin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * count方法，跟List接口的size一样，返回的都是这个集合流的元素的长度。
 * 不同的是，流是集合的一个高级工厂，中间操作是工厂里的每一道工序，我们对这个流操作完成后，可以进行元素的数量的和；
 *
 * min：取出数据中最小值
 */
public class CountDemo {

    public static void main(String[] args) {
        List<Admin> adminList = Arrays.asList(
                new Admin(1, "name" + 1, 10), new Admin(2, "name" + 2, 21),
                new Admin(3, "name" + 3, 34), new Admin(4, "name" + 4, 6),
                new Admin(5, "name" + 5, 55), new Admin(6, "name" + 6, 17)
        );

        Long count = adminList.stream().filter(e -> e.getAge() > 18).count();
        System.out.println("大于18的人数为：" + count);

        Integer min = adminList.stream().min(Comparator.comparing(Admin::getAge)).orElse(new Admin()).getAge();
        System.out.println("人群中的最小年龄为：" + min);

        Integer max = adminList.stream().max(Comparator.comparing(Admin::getAge)).orElse(new Admin()).getAge();
        System.out.println("人群中的最大年龄为" + max);

        /*
         * 结果：
         *      大于18的人数为：3
         *      人群中的最小年龄为：6
         *      人群中的最大年龄为55
         */
    }
}
