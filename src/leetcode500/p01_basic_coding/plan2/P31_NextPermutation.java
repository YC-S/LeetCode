package leetcode500.p01_basic_coding.plan2;

public class P31_NextPermutation {
  public void nextPermutation(int[] nums) {
    if (nums == null || nums.length <= 1) return;
    int i = nums.length - 2;
    while (i >= 0 && nums[i] >= nums[i + 1]) i--;
    if (i >= 0) {
      int j = nums.length - 1;
      while (nums[j] <= nums[i]) j--;
      swap(nums, i, j);
    }
    reverse(nums, i + 1, nums.length - 1);
  }

  public void swap(int[] A, int a, int b) {
    int tmp = A[a];
    A[a] = A[b];
    A[b] = tmp;
  }

  public void reverse(int[] A, int i, int j) {
    while (i < j) swap(A, i++, j--);
  }
}
