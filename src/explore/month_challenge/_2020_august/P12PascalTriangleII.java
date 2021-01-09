/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.month_challenge._2020_august;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/13
 */
public class P12PascalTriangleII {

  public static List<Integer> getRow(int rowIndex) {
    List<Integer> res = new ArrayList<>();
    res.add(1);
    for (int i = 1; i <= rowIndex; i++) {
      for (int j = i - 1; j >= 1; j--) {
        int tmp = res.get(j - 1) + res.get(j);
        res.set(j, tmp);
      }
      res.add(1);
    }
    return res;
  }

  public static void main(String[] args) {
    List<Integer> list = getRow(3);
    System.out.println(list);
  }
}
