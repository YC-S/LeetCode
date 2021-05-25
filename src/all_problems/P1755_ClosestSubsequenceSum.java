package all_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P1755_ClosestSubsequenceSum {
  int[] arr;

  public int minAbsDifference(int[] nums, int goal) {
    arr = nums;
    int n = nums.length;
    List<Integer> first = new ArrayList<>();
    List<Integer> second = new ArrayList<>();
    generate(0, n / 2, 0, first);
    generate(n / 2, n, 0, second);
    Collections.sort(first);
    int ans = Integer.MAX_VALUE;
    for (int secondSetSum : second) {
      int left = goal - secondSetSum;
      if (first.get(0) > left) {
        ans = Math.min(ans, Math.abs((first.get(0) + secondSetSum) - goal));
        continue;
      }
      if (first.get(first.size() - 1) < left) {
        ans = Math.min(ans, Math.abs((first.get(first.size() - 1) + secondSetSum) - goal));
        continue;
      }
      int pos = Collections.binarySearch(first, left);
      if (pos >= 0) return 0;
      else pos = -1 * (pos + 1);
      int low = pos - 1;
      ans = Math.min(ans, Math.abs(secondSetSum + first.get(low) - goal));
      ans = Math.min(ans, Math.abs(secondSetSum + first.get(pos) - goal));
    }
    return ans;
  }

  private void generate(int pos, int stop, int sum, List<Integer> list) {
    if (pos == stop) {
      list.add(sum);
      return;
    }
    generate(pos + 1, stop, sum, list);
    generate(pos + 1, stop, sum + arr[pos], list);
  }
}
