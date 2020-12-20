/*
 * Copyright (c) 2020. Yuanchen
 */

package java8;

import java.util.Arrays;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/15
 */
public class Distinct {

    public static void main(String[] args) {
        int[] array = {1, 1, 1, 2, 3, 4, 5, 5, 6};
        System.out.println(Arrays.toString(new Distinct().distinctValues(array)));
    }

    public int[] distinctValues(int[] array) {
        return Arrays.stream(array).distinct().toArray();
    }
}
