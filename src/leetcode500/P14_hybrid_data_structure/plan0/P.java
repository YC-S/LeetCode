package leetcode500.P14_hybrid_data_structure.plan0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P {
  public static int[] LongContiguousSubArr(int[] array, int target) {
    List<List<Integer>> list = permute(array, target);
    List<Integer> max = new ArrayList<>();
    for (List<Integer> li : list) {
      if (max.size() == 0 || max.size() < li.size()) {
        max = li;
      }
    }
    int[] res = new int[max.size()];
    for (int i = 0; i < res.length; i++) {
      res[i] = max.get(i);
    }
    return res;
  }

  public static List<List<Integer>> permute(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList<>();
    helper(0, res, nums, target);
    return res;
  }

  private static void helper(int index, List<List<Integer>> res, int[] nums, int target) {
    if (index == nums.length) {
      List<Integer> cur = new ArrayList<>();
      int sum = 0;
      for (int num : nums) {
        cur.add(num);

        sum += num;
      }
      if (sum == target) {
        res.add(cur);
      }
      return;
    }
    for (int i = index; i < nums.length; i++) {
      swap(nums, i, index);
      helper(index + 1, res, nums, target);
      swap(nums, i, index);
    }
  }

  private static void swap(int[] nums, int a, int b) {
    int tmp = nums[a];
    nums[a] = nums[b];
    nums[b] = tmp;
  }

  public static void main(String[] args) {
    int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(Arrays.toString(LongContiguousSubArr(arr, 6)));
  }
}
