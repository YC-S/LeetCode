/*
 * Copyright (c) 2020. Yuanchen
 */

package company.amazon.amazon_oa.ella;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/16
 */
public class Q2 {

    static int getMinimumUniqueSum(List<Integer> arr) {
        Collections.sort(arr);
        int n = arr.size();

        int sum = arr.get(0);
        int prev = arr.get(0);

        for (int i = 1; i < n; i++) {
            int curr = arr.get(i);

            if (prev >= curr) {
                curr = prev + 1;
            }
            sum += curr;
            prev = curr;
        }

        return sum;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(3, 2, 1, 2, 7);
        System.out.println(getMinimumUniqueSum(arr));
    }
}
