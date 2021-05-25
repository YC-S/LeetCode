package all_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P1751_MaximumNumberOfEventsThatCanBeAttendedII {
  public int maxValue(int[][] events, int k) {
    Arrays.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    Map<String, Integer> cache = new HashMap<>();
    return dfs(events, 0, 0, k, 0, cache);
  }

  public int dfs(int[][] events, int cur, int count, int k, int end, Map<String, Integer> cache) {
    if (count == k || cur == events.length) return 0;
    String key = count + "_" + end;
    Integer val = cache.get(key);
    if (val != null) return val;
    int max = dfs(events, cur + 1, count, k, end, cache);
    if (events[cur][0] > end)
      max =
          Math.max(max, dfs(events, cur + 1, count + 1, k, events[cur][1], cache) + events[cur][2]);
    cache.put(key, max);
    return max;
  }
}
