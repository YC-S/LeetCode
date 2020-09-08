/*
 * Copyright (c) 2020. Yuanchen
 */

package amazon;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/09/07
 *
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 */
public class Q5TrappingRainWater {

  public int trap(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }

    int left = 0, right = height.length - 1;
    int res = 0;
    int leftMax = 0, rightMax = 0;
    while (left < right) {
      if (height[left] < height[right]) {
        if (height[left] >= leftMax) {
          leftMax = height[left];
        } else {
          res += (leftMax - height[left]);
        }
        left++;
      } else {
        if (height[right] >= rightMax) {
          rightMax = height[right];
        } else {
          res += (rightMax - height[right]);
        }
        right--;
      }
    }
    return res;
  }

}
