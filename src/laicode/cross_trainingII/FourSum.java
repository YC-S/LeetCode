package laicode.cross_trainingII;

import java.util.HashMap;
import java.util.Map;

public class FourSum {
  public boolean exist(int[] array, int target) {
    Map<Integer, Pair> map = new HashMap<>();
    for (int i = 1; i < array.length; i++) {
      for (int j = 0; j < i; j++) {
        int pairSum = array[i] + array[j];
        if (map.containsKey(target - pairSum) && map.get(target - pairSum).right < j) return true;
        if (!map.containsKey(pairSum)) map.put(pairSum, new Pair(j, i));
      }
    }
    return false;
  }

  class Pair {
    int left;
    int right;

    public Pair(int left, int right) {
      this.left = left;
      this.right = right;
    }
  }
}
