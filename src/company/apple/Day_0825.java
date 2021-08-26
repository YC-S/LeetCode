package company.apple;

import java.util.HashMap;
import java.util.Map;

public class Day_0825 {
  public static int minDist(int[] array, int a, int b) {
    boolean foundA = false, foundB = false;
    int prev = -1, minDist = Integer.MAX_VALUE, n = array.length;
    for (int i = 0; i < n; i++) {
      if (array[i] == a) foundA = true;
      if (array[i] == b) foundB = true;
      if (array[i] == a || array[i] == b) {
        if (prev != -1 && array[i] != array[prev]) {
          minDist = Math.min(minDist, i - prev);
        }
        prev = i;
      }
    }
    if (!foundA || !foundB) return -1;
    if (minDist == Integer.MAX_VALUE) return 0;
    return minDist;
    // 主动解释一下代码。。。
    // Time: O(n)
    // Space: O(1)
  }

  public static void main(String[] args) {
    int[] nums = new int[] {10, 12, 8, 4, 3, 2, 12, 10, 9, 7, 8, 12, 11, 5};
    System.out.println(minDist(nums, 4, 4));
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      System.out.println(entry.getKey() + ":" + entry.getValue());
    }
  }
}
