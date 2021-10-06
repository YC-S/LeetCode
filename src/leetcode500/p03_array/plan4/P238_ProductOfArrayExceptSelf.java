package leetcode500.p03_array.plan4;

public class P238_ProductOfArrayExceptSelf {
  public int[] productExceptSelf(int[] nums) {
    int prev = 1;
    int[] res = new int[nums.length];
    for (int i = 1; i < nums.length; i++) {
      prev *= nums[i];
    }
    res[0] = prev;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == 0) {
        int tmp = 1;
        for (int j = 0; j < nums.length; j++) {
          if (j == i) continue;
          tmp *= nums[j];
        }
        res[i] = tmp;
      } else {
        res[i] = res[i - 1] / nums[i] * nums[i - 1];
      }
    }
    return res;
  }
}
