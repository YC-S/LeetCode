/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.Arrays;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/18
 */
public class P1196_HowManyApples {

    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        int i = 0;
        while (i < arr.length) {
            if (sum + arr[i] <= 5000) {
                sum += arr[i];
            } else {
                return i;
            }
            i++;
        }
        return i;
    }
}
