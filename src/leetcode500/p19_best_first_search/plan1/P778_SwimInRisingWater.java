package leetcode500.p19_best_first_search.plan1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class P778_SwimInRisingWater {
  public int swimInWater(int[][] grid) {
    int N = grid.length;
    int lo = grid[0][0], hi = N * N;
    while (lo < hi) {
      int mi = lo + (hi - lo) / 2;
      if (!possible(mi, grid)) {
        lo = mi + 1;
      } else {
        hi = mi;
      }
    }
    return lo;
  }

  public boolean possible(int T, int[][] grid) {
    int N = grid.length;
    Set<Integer> seen = new HashSet();
    seen.add(0);
    int[] dr = new int[] {1, -1, 0, 0};
    int[] dc = new int[] {0, 0, 1, -1};

    Deque<Integer> stack = new ArrayDeque<>();
    stack.offerFirst(0);

    while (!stack.isEmpty()) {
      int k = stack.pop();
      int r = k / N, c = k % N;
      if (r == N - 1 && c == N - 1) return true;

      for (int i = 0; i < 4; ++i) {
        int cr = r + dr[i], cc = c + dc[i];
        int ck = cr * N + cc;
        if (0 <= cr && cr < N && 0 <= cc && cc < N && !seen.contains(ck) && grid[cr][cc] <= T) {
          stack.add(ck);
          seen.add(ck);
        }
      }
    }

    return false;
  }
}
