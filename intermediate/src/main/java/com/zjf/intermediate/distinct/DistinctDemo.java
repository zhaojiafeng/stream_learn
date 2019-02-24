package com.zjf.intermediate.distinct;

import com.zjf.intermediate.model.Admin;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    distinct去除流中重复元素。
    distinct（）使用hashCode（）和equals（）方法来获取不同的元素
 */
public class DistinctDemo {

    public static void main(String[] args) {

        List<String> numList = Arrays.asList("AA", "BB", "CC", "BB", "CC", "AA", "AA");
        System.out.println("No. of distinct remain elements:" + numList.stream().distinct().count());
        System.out.println(numList.stream().distinct().collect(Collectors.joining(",")));
        /*
            输出结果：
                No. of distinct elements:3
                AA,BB,CC
         */

        System.out.println("-----------");

        Stream.of(new Admin("Allen", 25), new Admin("Bob", 26),
                new Admin("Bob", 26), new Admin("Bob", 26),
                new Admin("Cache", 29))
                .distinct()
                .forEach(x -> System.out.println(x.toString()));
        /*
         运行结果：
         Admin{id=null, adminName='lzj', password='null', age=25, deleteFlag=null, telephone='null', email='null'}
         Admin{id=null, adminName='zhangsan', password='null', age=26, deleteFlag=null, telephone='null', email='null'}
         Admin{id=null, adminName='zhaowu', password='null', age=29, deleteFlag=null, telephone='null', email='null'}
         */

        System.out.println("-----------");

        // 如果想按照对象的属性，对对象列表进行去重，我们可以通过其它方法来实现。
        // distinctByKey 方法可以被Stream接口的 filter()接收为参数
        // distinctByKey()方法返回一个使用ConcurrentHashMap 来维护先前所见状态的 Predicate 实例，如下是一个完整的使用对象属性来进行去重的示例。
        Stream.of(new Admin("Allen", 25), new Admin("Bob", 26),
                new Admin("Bob", 26), new Admin("Bob", 26),
                new Admin("Cache", 29))
                .filter(distinctByKey(Admin::getAdminName))
                .forEach(System.out::println);
    }


    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}
