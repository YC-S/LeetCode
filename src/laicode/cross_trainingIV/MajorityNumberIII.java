package laicode.cross_trainingIV;

import java.util.*;

public class MajorityNumberIII {
  public List<Integer> majority(int[] array, int k) {
    // Write your solution here
    List<Integer> list = new ArrayList<>();
    if (array == null || array.length == 0) {
      return list;
    }
    Map<Integer, Integer> map = new HashMap<>();
    for (int value : array) {
      if (map.containsKey(value)) {
        map.put(value, map.get(value) + 1);
      } else if (map.size() < k - 1) {
        map.put(value, 1);
      } else {
        Iterator<Map.Entry<Integer, Integer>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
          Map.Entry<Integer, Integer> curr = iter.next();
          int count = curr.getValue();
          if (count == 1) {
            iter.remove();
          } else {
            curr.setValue(count--);
          }
        }
      }
    }
    Map<Integer, Integer> countMap = new HashMap<>();
    for (int j : array) {
      if (map.containsKey(j)) {
        Integer count = countMap.get(j);
        if (count == null) {
          count = 1;
        } else {
          count++;
        }
        countMap.put(j, count);
      }
    }
    for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
      if (entry.getValue() > array.length / k) {
        list.add(entry.getKey());
      }
    }
    return list;
  }
}
