/*
 * Copyright (c) 2020. Yuanchen
 */

package 牛客网.Java专项练习;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/01
 */
public class Demo {

    public static void main(String[] args) {
        System.out.println(Math.round(11.5));
        System.out.println(Math.round(-11.5));
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 3, 1));
        System.out.println(list);
        list.add(6);
        list.add(0, 4);
        list.remove(1);
        System.out.println(list);
        char s = '\u0639';
        String st = "Hello, world\0";
        int d = 100;
    }
}