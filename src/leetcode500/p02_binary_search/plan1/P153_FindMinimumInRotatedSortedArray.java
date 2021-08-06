package leetcode500.p02_binary_search.plan1;

public class P153_FindMinimumInRotatedSortedArray {
  public int findMin(int[] nums) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = (left + right) >>> 1;
      if (mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid];
      else if (nums[left] <= nums[mid] && nums[right] <= nums[mid]) left = mid + 1;
      else right = mid - 1;
    }
    return nums[left];
  }
}
