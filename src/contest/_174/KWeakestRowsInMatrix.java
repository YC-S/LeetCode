package contest._174;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class KWeakestRowsInMatrix {

  public static int[] kWeakestRows(int[][] mat, int k) {
    int[] res = new int[k];
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < mat.length; i++) {
      int cnt = 0;
      for (int j = 0; j < mat[i].length; j++) {
        if (mat[i][j] == 1) {
          cnt++;
        }
      }
      map.put(i, cnt);
    }

    PriorityQueue<Entry<Integer, Integer>> pq =
      new PriorityQueue<>(
        k,
        (o1, o2) -> {
          if (o1.getValue().equals(o2.getValue())) {
            return o1.getKey() - o2.getKey();
          } else {
            return o1.getValue() - o2.getValue();
          }
        });

    pq.addAll(map.entrySet());
    for (int i = 0; i < k; i++) {
      res[i] = pq.poll().getKey();
    }
    return res;
  }

  public static void main(String[] args) {
    int[][] matrix = {{1, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}};
    System.out.println(Arrays.toString(kWeakestRows(matrix, 2)));

    int[][] matrix2 = {
      {1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}
    };
    System.out.println(Arrays.toString(kWeakestRows(matrix2, 3)));
  }
}
