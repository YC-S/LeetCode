package leetcode500.p03_array.plan2;

public class P27_RemoveElement {
  public int removeElement(int[] nums, int val) {
    int i = 0, j = nums.length - 1;
    while (i <= j) {
      if (nums[i] == val) {
        swap(nums, i, j--);
      } else {
        i++;
      }
    }
    return i;
  }

  private void swap(int[] nums, int a, int b) {
    int tmp = nums[a];
    nums[a] = nums[b];
    nums[b] = tmp;
  }
}
