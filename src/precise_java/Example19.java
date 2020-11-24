/*
 * Copyright (c) 2020. Yuanchen
 */

package precise_java;

import java.util.Arrays;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/22
 */
public class Example19 {

    public static void main(String[] args) {
        Number[] a = new Integer[10];
        double d = 3.14;
        int i = 117;
        Number n = i;
        a[0] = i;
        a[1] = n;
        a[2] = (int) d;
        System.out.println(Arrays.toString(a));
    }

}
