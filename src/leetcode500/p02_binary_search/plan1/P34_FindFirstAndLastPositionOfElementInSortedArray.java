package leetcode500.p02_binary_search.plan1;

public class P34_FindFirstAndLastPositionOfElementInSortedArray {
  public int[] searchRange(int[] nums, int target) {
    int first = findFirst(nums, target);
    int last = findLast(nums, target);
    return new int[] {first, last};
  }

  private int findFirst(int[] nums, int target) {
    if (nums == null || nums.length == 0) return -1;
    int left = 0, right = nums.length - 1;
    while (left < right - 1) {
      int mid = (left + right) >>> 1;
      if (nums[mid] >= target) right = mid;
      else left = mid;
    }
    if (nums[left] == target) return left;
    else if (nums[right] == target) return right;
    else return -1;
  }

  private int findLast(int[] nums, int target) {
    if (nums == null || nums.length == 0) return -1;
    int left = 0, right = nums.length - 1;
    while (left < right - 1) {
      int mid = (left + right) >>> 1;
      if (nums[mid] <= target) left = mid;
      else right = mid;
    }
    if (nums[right] == target) return right;
    else if (nums[left] == target) return left;
    else return -1;
  }
}
