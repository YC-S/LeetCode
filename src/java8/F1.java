/*
 * Copyright (c) 2020. Yuanchen
 */

package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/09/30
 */
public class F1 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("foo");
        list.add("bar");
        list.add("abc");
        String[] array = list.toArray(new String[0]);
        System.out.println(Arrays.toString(array));
    }
}
