/*
 * Copyright (c) 2020. Yuanchen
 */

package array;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/30
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1, max = 0, cur = 0;
        while (l < r) {
            cur = Math.min(height[r], height[l]) * (r - l);
            max = Math.max(cur, max);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {1, 1};
        System.out.println(maxArea(height));
        System.out.println(maxArea(new int[]{4, 3, 2, 1, 4}));
        System.out.println(maxArea(new int[]{1, 2, 1}));
    }
}
