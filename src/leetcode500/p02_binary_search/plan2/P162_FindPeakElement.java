package leetcode500.p02_binary_search.plan2;

public class P162_FindPeakElement {
  public int findPeakElement(int[] nums) {
    int l = 0, r = nums.length - 1;
    while (l < r) {
      int mid = (l + r) >>> 1;
      if (nums[mid] > nums[mid + 1]) r = mid;
      else l = mid + 1;
    }
    return l;
  }
}
