package leetcode500.p22_dp.plan7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P403_FrogJump {
  public boolean canCross(int[] stones) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int stone : stones) {
      map.put(stone, new HashSet<>());
    }
    map.get(0).add(0);
    for (int stone : stones) {
      for (int k : map.get(stone)) {
        if (k - 1 > 0 && map.containsKey(stone + k - 1)) {
          map.get(stone + k - 1).add(k - 1);
        }
        if (k > 0 && map.containsKey(stone + k)) {
          map.get(stone + k).add(k);
        }
        if (k + 1 > 0 && map.containsKey(stone + k + 1)) {
          map.get(stone + k + 1).add(k + 1);
        }
      }
    }
    return !map.get(stones[stones.length - 1]).isEmpty();
  }
}
