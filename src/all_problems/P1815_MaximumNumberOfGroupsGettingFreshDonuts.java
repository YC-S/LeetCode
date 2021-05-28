package all_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P1815_MaximumNumberOfGroupsGettingFreshDonuts {
  public int maxHappyGroups(int batchSize, int[] groups) {
    int n = groups.length;
    int[] cnt = new int[batchSize];
    int res = 0;
    int remGroup = 0;
    for (int group : groups) {
      int gr = group % batchSize;
      cnt[gr]++;
      if (gr != 0) remGroup++;
    }
    for (int i = 1; i <= batchSize / 2; i++) {
      int val = Math.min(cnt[i], cnt[batchSize - i]);
      if (batchSize % 2 == 0 && i == batchSize / 2) {
        val = cnt[i] / 2;
      }
      res += val;
      cnt[i] -= val;
      cnt[batchSize - i] -= val;
      remGroup -= val * 2;
    }
    res += cnt[0];
    res += dfs(0, cnt, remGroup, new HashMap<>());
    return (res);
  }

  public int dfs(int curr, int[] cnt, int remGroup, Map<String, Integer> memo) {
    int n = cnt.length;
    if (remGroup == 0) return (0);
    String key = curr + Arrays.toString(cnt);
    if (memo.containsKey(key)) return (memo.get(key));
    int res = 0;
    if (curr == 0) {
      res++;
      curr = n;
    }
    int val = 0;
    for (int i = 1; i < n; i++) {
      // remainder of i cnt is 0
      if (cnt[i] == 0) continue;
      cnt[i]--;
      int curRem = remGroup - 1;
      int nextCurr = curr - i;
      if (nextCurr < 0) nextCurr += n;
      val = Math.max(val, dfs(nextCurr, cnt, curRem, memo));
      cnt[i]++;
    }
    res += val;
    memo.put(key, res);
    return (res);
  }
}
