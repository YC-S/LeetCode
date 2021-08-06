package leetcode500.p02_binary_search.plan1;

public class P35_SearchInsertPosition {
  public int searchInsert(int[] nums, int target) {
    if (nums == null || nums.length == 0) return 0;
    int n = nums.length;
    if (target > nums[n - 1]) return n;
    if (target < nums[0]) return 0;
    int left = 0, right = n - 1;
    while (left < right - 1) {
      int mid = (left + right) >>> 1;
      if (nums[mid] == target) return mid;
      else if (nums[mid] < target) left = mid;
      else right = mid;
    }
    if (nums[left] == target) return left;
    else if (nums[right] == target) return right;
    else return right;
  }
}
