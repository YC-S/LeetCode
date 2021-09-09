package leetcode500.p03_array.plan1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P18_4Sum {
  public static List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < nums.length - 3; i++) {
      if (i > 0 && nums[i - 1] == nums[i]) {
        continue;
      }
      for (int j = i + 1; j < nums.length - 2; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }
        int left = j + 1, right = nums.length - 1;
        while (left < right) {

          int sum = nums[i] + nums[j] + nums[left] + nums[right];
          if (sum == target) {
            res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
            left++;
            right--;
            while (left < right && nums[left] == nums[left - 1]) left++;
            while (left < right && nums[right] == nums[right + 1]) right--;
          } else if (sum < target) {
            left++;
          } else {
            right--;
          }
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0));
  }
}
