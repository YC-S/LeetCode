/*
 * Copyright (c) 2020. Yuanchen
 */

package book.jzOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/16
 */
public class FindNumbersWithSum {

    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        List<ArrayList<Integer>> list = new ArrayList<>();
        int left = 0, right = array.length - 1, cur = 0;
        while (left < right) {
            cur = array[left] + array[right];
            if (cur < sum) {
                left++;
            } else if (cur > sum) {
                right--;
            } else {
                ArrayList<Integer> newList = new ArrayList<>();
                newList.add(array[left]);
                newList.add(array[right]);
                return newList;
            }
        }

        return new ArrayList<>();

    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 11, 15};
        System.out.println(FindNumbersWithSum(array, 15));
    }
}
