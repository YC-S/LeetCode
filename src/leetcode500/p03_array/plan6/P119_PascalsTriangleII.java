package leetcode500.p03_array.plan6;

import java.util.ArrayList;
import java.util.List;

public class P119_PascalsTriangleII {
  public List<Integer> getRow(int rowIndex) {
    List<Integer> res = new ArrayList<>();

    for (int i = 1; i <= rowIndex + 1; i++) {
      res.add(0, 1);
      for (int j = 1; j < i - 1; j++) {
        res.set(j, res.get(j) + res.get(j + 1));
      }
    }
    return res;
  }
}
