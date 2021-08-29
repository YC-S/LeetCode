package leetcode500.p26_sweep_line.plan1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P554_BrickWall {
  public int leastBricks(List<List<Integer>> wall) {
    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;
    for (List<Integer> row : wall) {
      int sum = 0;
      for (int num : row) {
        sum += num;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        count = Math.max(count, map.get(sum));
      }
    }
    return wall.size() - count;
  }
}
