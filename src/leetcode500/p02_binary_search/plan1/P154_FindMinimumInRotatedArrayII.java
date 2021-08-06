package leetcode500.p02_binary_search.plan1;

public class P154_FindMinimumInRotatedArrayII {
  public int findMin(int[] nums) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = (left + right) >>> 1;
      if (nums[mid] < nums[right]) {
        right = mid;
      } else if (nums[mid] > nums[right]) {
        left = mid + 1;
      } else {
        right--;
      }
    }
    return nums[left];
  }
}
