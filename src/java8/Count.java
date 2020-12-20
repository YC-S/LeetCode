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
public class Count {

    public static void main(String[] args) {
        int[] array = {1, 1, 1, 1, 12, 2, 3, 3, 4, 5, 5, 6, 4, 2, 2, 4, 6, 5, 2, 23, 4};
        System.out.println(new Count().countOccurance(array, 1));
    }

    public long countOccurance(int[] array, int target) {
        return Arrays.stream(array).filter(num -> num == target).count();
    }
}
