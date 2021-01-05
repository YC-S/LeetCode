package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/06/01
 */
public class P11_ContainerWithMostWater {

  public int maxArea(int[] height) {
    int max = 0, l = 0, r = height.length - 1;
    while (l < r) {
      max = Math.max(max, (r - l) * (Math.min(height[l], height[r])));
      if (height[l] < height[r]) {
        l++;
      } else {
        r--;
      }
    }
    return max;
  }
}
