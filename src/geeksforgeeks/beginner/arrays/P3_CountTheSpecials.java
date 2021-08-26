package geeksforgeeks.beginner.arrays;

import java.util.HashMap;
import java.util.Map;

public class P3_CountTheSpecials {
  static void countSpecials(int[] a, int n, int k) {
    int f = (int) Math.floor(n / k);
    Map<Integer, Integer> count = new HashMap<>();
    for (int i = 0; i < a.length; i++) {
      count.put(a[i], count.getOrDefault(a[i], 0) + 1);
    }
    int res = 0;
    for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
      if (entry.getValue() == f) {
        res++;
      }
    }
    System.out.println(res);
  }

  public static void main(String[] args) {
    countSpecials(new int[] {1, 4, 1, 2, 4}, 5, 2);
  }
}
