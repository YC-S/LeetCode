package leetcode500.p18_bfs;

import java.util.Arrays;

public class P787_CheapestFlightsWithKStops {
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;
    for (int i = 0; i <= K; i++) { // Relax all edges for K times
      int[] temp = Arrays.copyOf(dist, dist.length);
      for (int[] edge : flights) { // Go over all edges
        int u = edge[0];
        int v = edge[1];
        int w = edge[2];
        if (dist[u] == Integer.MAX_VALUE) continue;
        if (dist[u] + w < temp[v]) { // relax function
          temp[v] = dist[u] + w;
        }
      }
      dist = temp;
    }
    return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
  }
}
