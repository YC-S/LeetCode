package leetcode500.p03_array.plan6;

import java.util.ArrayList;
import java.util.List;

public class P118_PascalsTriangle {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();

    for (int i = 1; i <= numRows; i++) {
      cur.add(0, 1);
      for (int j = 1; j < i - 1; j++) {
        cur.set(j, cur.get(j) + cur.get(j + 1));
      }
      res.add(new ArrayList<>(cur));
    }

    return res;
  }
}
