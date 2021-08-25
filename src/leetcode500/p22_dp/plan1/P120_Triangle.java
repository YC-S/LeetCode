package leetcode500.p22_dp.plan1;

import java.util.List;

public class P120_Triangle {
  public int minimumTotal(List<List<Integer>> triangle) {
    int[] arr = new int[triangle.size() + 1];
    for (int i = triangle.size() - 1; i >= 0; i--) {
      for (int j = 0; j < triangle.get(i).size(); j++) {
        arr[j] = Math.min(arr[j], arr[j + 1]) + triangle.get(i).get(j);
      }
    }
    return arr[0];
  }
}
