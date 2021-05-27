package all_problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class P1851_MinimumIntervalToIncludeEachQuery {
  public int[] minInterval(int[][] intervals, int[] queries) {
    TreeMap<Integer, Integer> pq = new TreeMap<>();
    HashMap<Integer, Integer> res = new HashMap<>();
    int i = 0, n = intervals.length, m = queries.length;
    int[] Q = queries.clone(), res2 = new int[m];
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    Arrays.sort(Q);
    for (int q : Q) {
      while (i < n && intervals[i][0] <= q) {
        int l = intervals[i][0], r = intervals[i++][1];
        pq.put(r - l + 1, r);
      }
      while (!pq.isEmpty() && pq.firstEntry().getValue() < q) {
        pq.pollFirstEntry();
      }
      res.put(q, pq.isEmpty() ? -1 : pq.firstKey());
    }
    i = 0;
    for (int q : queries) {
      res2[i++] = res.get(q);
    }
    return res2;
  }
}
