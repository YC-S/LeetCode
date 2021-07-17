package leetcode_dp;

public class P42_TrappingRainWater {
  public int trap(int[] height) {
    int left = 0, right = height.length - 1, leftMax = 0, rightMax = 0, res = 0;
    while (left < right) {
      leftMax = Math.max(leftMax, height[left]);
      rightMax = Math.max(rightMax, height[right]);
      if (leftMax < rightMax) {
        res += leftMax - height[left];
        left++;
      } else {
        res += rightMax - height[right];
        right--;
      }
    }
    return res;
  }
}
