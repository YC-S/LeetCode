package leetcode500.p03_array.plan2;

public class P80_RemoveDuplicatesFromSortedArray {
  public int removeDuplicates(int[] nums) {
    int j = 1, count = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) count++;
      else count = 1;
      if (count <= 2) {
        nums[j++] = nums[i];
      }
    }
    return j;
  }
}
