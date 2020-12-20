/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.Arrays;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/18 Input: arr = [1,2,3] Output: 2 Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
 */
public class P1426_CountingElements {

    public static int countElements(int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        int prefix = 1;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] != arr[i - 1]) {
                if (arr[i] == arr[i - 1] + 1) {
                    count += prefix;
                }
                prefix = 0;
            }
            prefix++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(countElements(arr));
    }
}
