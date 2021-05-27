package all_problems;

public class P1852_DistinctNumbersInEachSubarray {
  public int[] distinctNumbers(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return new int[0];
    }
    int n = nums.length, l = 0, r = 0, count = 0;
    int[] res = new int[n - k + 1];
    int[] map = new int[(int) 1e5 + 1];
    while (r < n) {
      if (map[nums[r]]++ == 0) count++;
      if (r >= k - 1) {
        res[l] = count;
        if (--map[nums[l]] == 0) count--;
        l++;
      }
      r++;
    }
    return res;
  }
}
