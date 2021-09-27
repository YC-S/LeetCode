package leetcode500.p03_array.plan2;

public class P26_RemoveDuplicatesFromSortedArray {
  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int s = 0, f = 1;
    while (f < nums.length) {
      if (nums[s] == nums[f]) {
        f++;
      } else {
        if (s == f - 1) {
          s++;
          f++;
        } else {
          nums[++s] = nums[f];
          f++;
        }
      }
    }
    return s + 1;
  }
}
