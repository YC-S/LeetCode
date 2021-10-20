package leetcode500.p03_array.plan6;

public class P280_WiggleSort {
  public void wiggleSort(int[] nums) {
    boolean less = true;
    for (int i = 0; i < nums.length - 1; i++) {
      if (less) {
        if (nums[i] > nums[i + 1]) {
          swap(nums, i, i + 1);
        }
      } else {
        if (nums[i] < nums[i + 1]) {
          swap(nums, i, i + 1);
        }
      }
      less = !less;
    }
  }

  private void swap(int[] nums, int a, int b) {
    int tmp = nums[a];
    nums[a] = nums[b];
    nums[b] = tmp;
  }
}
