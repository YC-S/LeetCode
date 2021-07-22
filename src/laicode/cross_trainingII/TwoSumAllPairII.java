package laicode.cross_trainingII;

import java.util.*;

public class TwoSumAllPairII {
  public List<List<Integer>> allPairs(int[] array, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : array) {
      Integer count = map.get(num);
      if (num * 2 == target && count != null && count == 1) {
        result.add(Arrays.asList(num, num));
      } else if (map.containsKey(target - num) && count == null) {
        result.add(Arrays.asList(target - num, num));
      }
      if (count == null) map.put(num, 1);
      else map.put(num, count + 1);
    }
    return result;
  }
}
