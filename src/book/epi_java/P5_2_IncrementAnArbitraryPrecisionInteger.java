/*
 * Copyright (c) 2020. Yuanchen
 */

package book.epi_java;

import java.util.Arrays;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/13
 */
public class P5_2_IncrementAnArbitraryPrecisionInteger {

    public static List<Integer> plusOne(List<Integer> A) {
        int n = A.size() - 1;
        A.set(n, A.get(n) + 1);
        for (int i = n; i > 0 && A.get(i) == 10; --i) {
            A.set(i, 0);
            A.set(i - 1, A.get(i - 1) + 1);
        }
        if (A.get(0) == 10) {
            A.set(0, 1);
            A.add(0);
        }
        return A;
    }

    public static void main(String[] args) {
        System.out.println(plusOne(Arrays.asList(1, 2, 9)));
    }
}
