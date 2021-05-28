package all_problems;

public class P1827_MinimumOperationsToMakeTheArrayIncreasing {
  public int minOperations(int[] nums) {
    int cnt = 0, prev = 0;
    for (int cur : nums) {
      if (cur <= prev) {
        cnt += ++prev - cur;
      } else {
        prev = cur;
      }
    }
    return cnt;
  }
}
