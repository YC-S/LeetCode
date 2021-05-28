package all_problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P1834_SingleThreadedCPU {
  public int[] getOrder(int[][] tasks) {
    int n = tasks.length;
    int[] ans = new int[n];
    int[][] extTasks = new int[n][3];
    for (int i = 0; i < n; i++) {
      extTasks[i][0] = i;
      extTasks[i][1] = tasks[i][0];
      extTasks[i][2] = tasks[i][1];
    }
    Arrays.sort(extTasks, Comparator.comparingInt(a -> a[1]));
    PriorityQueue<int[]> pq =
        new PriorityQueue<>((a, b) -> a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]);
    int time = 0;
    int ai = 0;
    int ti = 0;
    while (ai < n) {
      while (ti < n && extTasks[ti][1] <= time) {
        pq.offer(extTasks[ti++]);
      }
      if (pq.isEmpty()) {
        time = extTasks[ti][1];
        continue;
      }
      int[] bestFit = pq.poll();
      ans[ai++] = bestFit[0];
      time += bestFit[2];
    }
    return ans;
  }
}
