package leetcode500.p02_binary_search.plan2;

public class P540_SingleElementInASortedArray {
  public int singleNonDuplicate(int[] nums) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = (left + right) >>> 1;
      if ((mid % 2 == 0) && nums[mid] == nums[mid + 1]
          || (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return nums[left];
  }
}
