package leetcode500.p03_array.plan0;

import java.util.*;

public class P498_DiagonalTraverse {
  public static void main(String[] args) {
    int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    System.out.println(Arrays.toString(new P498_DiagonalTraverse().findDiagonalOrder(mat)));
  }

  public int[] findDiagonalOrder(int[][] mat) {
    TreeMap<Integer, List<Integer>> map = new TreeMap<>();
    int rows = mat.length;
    int cols = mat[0].length;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (!map.containsKey(i + j)) {
          map.put(i + j, new ArrayList<>());
        }
        map.get(i + j).add(mat[i][j]);
      }
    }

    int[] result = new int[rows * cols];
    int idx = 0;
    for (int i : map.keySet()) {
      List<Integer> list = map.get(i);
      if (i % 2 == 0) {
        Collections.reverse(list);
      }
      for (int number : list) result[idx++] = number;
    }
    return result;
  }
}
