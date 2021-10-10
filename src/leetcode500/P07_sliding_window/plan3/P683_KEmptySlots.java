package leetcode500.P07_sliding_window.plan3;

public class P683_KEmptySlots {
  public int kEmptySlots(int[] bulbs, int k) {
    int[] days = new int[bulbs.length];
    for (int i = 0; i < bulbs.length; i++) days[bulbs[i] - 1] = i + 1;
    int left = 0, right = k + 1, res = Integer.MAX_VALUE;
    for (int i = 0; right < days.length; i++) {
      if (days[i] < days[left] || days[i] <= days[right]) {
        if (i == right)
          res = Math.min(res, Math.max(days[left], days[right])); // we get a valid subarray
        left = i;
        right = k + 1 + i;
      }
    }
    return (res == Integer.MAX_VALUE) ? -1 : res;
  }
}
