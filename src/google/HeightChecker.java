/*
 * Copyright (c) 2020. Yuanchen
 */

package google;

import java.util.Arrays;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/11
 */
public class HeightChecker {

    // Students are asked to stand in non-decreasing order of heights for an annual photo.
    //
    // Return the minimum number of students that must move in order for all students to be standing in non-decreasing
    // order of height.
    //
    // Notice that when a group of students is selected they can reorder in any possible way between themselves and the
    // non selected students remain on their seats.
    // Example 1:
    // [1,1,4,2,1,3] => [1,1,1,2,3,4] output 3
    // Example 2:
    // [5,1,2,3,4] => [1,2,3,4,5]
    // Example 3:
    // [1,2,3,4,5] => 0

    public static void main(String[] args) {
        HeightChecker solution = new HeightChecker();
        System.out.println(solution.heightChecker(new int[]{1, 2, 3, 4, 5}));
        System.out.println(solution.heightChecker(new int[]{5, 1, 2, 3, 4}));
        System.out.println(solution.heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
    }

    public int heightChecker(int[] heights) {
        int steps = 0;
        int[] copy = Arrays.copyOf(heights, heights.length);
        Arrays.sort(copy);
        for (int i = 0; i < heights.length; i++) {
            if (copy[i] != heights[i]) {
                steps++;
            }
        }

        return steps;
    }

    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
