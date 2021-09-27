package leetcode500.p03_array.plan2;

public class P283_MoveZeroes {
  public void moveZeroes(int[] nums) {
    int i = 0, j = 0;
    while (i++ < nums.length) {
      if (nums[i] != 0) {
        swap(nums, i, j++);
      }
    }
  }

  private void swap(int[] nums, int a, int b) {
    int tmp = nums[a];
    nums[a] = nums[b];
    nums[b] = tmp;
  }
}
