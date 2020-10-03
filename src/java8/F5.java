/*
 * Copyright (c) 2020. Yuanchen
 */

package java8;

import java.util.stream.Stream;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/10/03
 */
public class F5 {

    public static void main(String[] args) {
        Stream.of("Abby", "Alex", "Cathy", "David").filter(x -> x.startsWith("A")).forEach(System.out::print);
    }

}
