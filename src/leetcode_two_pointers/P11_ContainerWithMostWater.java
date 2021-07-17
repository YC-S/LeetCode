package leetcode_two_pointers;

public class P11_ContainerWithMostWater {
  public int maxArea(int[] height) {
    int left = 0, right = height.length - 1, res = 0;
    while (left < right) {
      int leftMax = height[left];
      int rightMax = height[right];
      if (leftMax < rightMax) {
        res = Math.max(res, leftMax * (right - left));
        left++;
      } else {
        res = Math.max(res, rightMax * (right - left));
        right--;
      }
    }
    return res;
  }
}
