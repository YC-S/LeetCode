package all_problems;

import java.util.Arrays;

public class P1887_ReductionOperationsToMakeTheArrayElementsEqual {
  public int reductionOperations(int[] nums) {
    Arrays.sort(nums);
    int sum = 0;
    for (int i = nums.length - 1; i > 0; i--) {
      if (nums[i] == nums[i - 1]) continue;
      else sum += nums.length - i;
    }
    return sum;
  }
}
