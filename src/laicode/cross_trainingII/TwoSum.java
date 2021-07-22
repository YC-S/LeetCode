package laicode.cross_trainingII;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {
  public boolean existSum(int[] array, int target) {
    Set<Integer> set = new HashSet<>();
    for (int num : array) {
      if (set.contains(target - num)) return true;
      set.add(num);
    }
    return false;
  }
}
