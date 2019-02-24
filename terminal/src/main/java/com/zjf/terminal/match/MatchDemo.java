package com.zjf.terminal.match;

import com.zjf.terminal.model.Admin;

import java.util.stream.Stream;

/*

 */
public class MatchDemo {

    public static void main(String[] args) {

        Stream<Admin> adminStream = Stream.of(
                new Admin(1, "name" + 1, 10), new Admin(2, "name" + 2, 21),
                new Admin(3, "name" + 3, 34), new Admin(4, "name" + 4, 6),
                new Admin(5, "name" + 5, 55), new Admin(6, "name" + 6, 17)
        );

        boolean isAllAdult = adminStream.
                allMatch(p -> p.getAge() > 18);
        System.out.println("All are adult? " + isAllAdult);
        boolean isThereAnyChild = adminStream.
                anyMatch(p -> p.getAge() < 12);
        System.out.println("Any child? " + isThereAnyChild);

        /*
            输出结果：
                All are adult? false
                Any child? true
         */
    }
}
