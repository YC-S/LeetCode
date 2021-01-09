/*
 * Copyright (c) 2020. Yuanchen
 */

package book.jzOffer;

import java.util.Arrays;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/15
 */
public class MinNumberInRotatedArray {

    public int minNumberInRotateArray(int[] array) {
        Arrays.sort(array);
        return array[0];
    }
}
