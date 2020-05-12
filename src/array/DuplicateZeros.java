/*
 * Copyright (c) 2020. Yuanchen
 */

package array;

import java.util.Arrays;

/**
 * @author shiyuanchen
 * @created 2020/05/12
 * @project LeetCode
 */
public class DuplicateZeros {

    public static void duplicateZeros(int[] arr) {
        int[] res = new int[arr.length];
        int i = 0, j = 0;
        while (j < res.length) {
            if (arr[i] == 0) {
                res[j] = 0;
                if (j + 1 < res.length) {
                    res[j + 1] = 0;
                } else {
                    break;
                }
                i++;
                j += 2;
            } else {
                res[j] = arr[i];
                i++;
                j++;
            }
        }
        for (int k = 0; k < arr.length; k++) {
            arr[k] = res[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}
