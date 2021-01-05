/*
 * Copyright (c) 2020. Yuanchen
 */

package month_challenge._2020_june;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/06/14
 */
public class P14CheapestFlightsWithinKStops {

  public int findCheapestPrice(int n, int[][] flights, int src, int dst,
    int K) {
    final int INF = 0x3f3f3f3f;
    int m = flights.length;
    int[] dis = new int[n];
    for (int i = 0; i < n; i++) {
      dis[i] = INF;
    }
    dis[src] = 0;

    boolean[] updated = new boolean[n];
    for (int I = 0; I <= K; I++) {
      for (int i = 0; i < m; i++) {
        int u = flights[i][0];
        int v = flights[i][1];
        int w = flights[i][2];
        if (updated[u] == false && dis[u] + w < dis[v]) {
          dis[v] = dis[u] + w;
          updated[v] = true;
        }
      }
      for (int i = 0; i < n; i++) {
        updated[i] = false;
      }
    }

    return dis[dst] == INF ? -1 : dis[dst];
  }
}
