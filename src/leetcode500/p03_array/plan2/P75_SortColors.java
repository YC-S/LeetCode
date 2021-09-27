package leetcode500.p03_array.plan2;

public class P75_SortColors {
  public void sortColors(int[] nums) {
    // (0, i) are all 0s
    // [i, j) are all 1s
    // [j, k] are unexplored area
    // (k, n - 1) are all 2s
    int i = 0, j = 0, k = nums.length - 1;
    while (j <= k) {
      if (nums[j] == 0) {
        swap(nums, i++, j++);
      } else if (nums[j] == 1) {
        j++;
      } else {
        swap(nums, j, k--);
      }
    }
  }

  private void swap(int[] array, int a, int b) {
    int tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
  }
}
