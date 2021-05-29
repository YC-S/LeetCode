package all_problems;

import java.util.*;

public class P1878_GetBiggestThreeRhombusSumsInAGrid {
  public static boolean safe(int n, int m, int i, int j, int side) {
    if (i + side >= n || j + side >= m || i - side < 0) return false;
    return j + 2 * side < m;
  }

  public int[] getBiggestThree(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    HashSet<Integer> set = new HashSet<>();
    int maxSide = 1 + Math.min(n, m) / 2;
    for (int i = 0; i < n; i++) {
      outer:
      for (int j = 0; j < m; j++) {
        set.add(grid[i][j]);
        for (int k = 1; k <= maxSide; k++) {
          if (!safe(n, m, i, j, k)) continue outer;
          int sum = 0;
          int r = i, c = j;
          for (int a = 0; a < k; a++) sum += grid[--r][++c];
          for (int a = 0; a < k; a++) sum += grid[++r][++c];
          for (int a = 0; a < k; a++) sum += grid[++r][--c];
          for (int a = 0; a < k; a++) sum += grid[--r][--c];
          set.add(sum);
        }
      }
    }
    Iterator<Integer> it = set.iterator();
    List<Integer> list = new ArrayList<>();
    while (it.hasNext()) list.add(it.next());
    Collections.sort(list);
    int[] ans = new int[Math.min(set.size(), 3)];
    for (int k = 0; k < Math.min(list.size(), 3); k++) ans[k] = list.get(list.size() - 1 - k);
    return ans;
  }
}
