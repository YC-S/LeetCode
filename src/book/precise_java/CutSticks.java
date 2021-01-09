/*
 * Copyright (c) 2020. Yuanchen
 */

package book.precise_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/20
 */
public class CutSticks {

    static int[] cutTheSticks(int[] arr) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(arr);
        res.add(arr.length);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                res.add(arr.length - i);
            }
        }
        int[] a = new int[res.size()];
        for (int i = 0; i < a.length; ++i) {
            a[i] = res.get(i);
        }
        return a;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 4, 2, 2, 8};
        cutTheSticks(arr);
    }
}

