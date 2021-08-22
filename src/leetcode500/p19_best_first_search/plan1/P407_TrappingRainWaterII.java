package leetcode500.p19_best_first_search.plan1;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P407_TrappingRainWaterII {
  public int trapRainWater(int[][] heightMap) {
    if (heightMap == null || heightMap.length < 3 || heightMap[0].length < 3) {
      return 0;
    }
    int waterSum = 0;
    final int[] dx = {0, 1, 0, -1};
    final int[] dy = {1, 0, -1, 0};
    final int M = heightMap.length;
    final int N = heightMap[0].length;
    boolean[][] visited = new boolean[M][N];
    PriorityQueue<Node> queue =
        new PriorityQueue<>(
            new Comparator<Node>() {
              @Override
              public int compare(Node left, Node right) {
                if (left.h == right.h) {
                  return 0;
                }
                return left.h < right.h ? -1 : 1;
              }
            });
    for (int i = 0; i < M; i++) {
      queue.add(new Node(i, 0, heightMap[i][0]));
      queue.add(new Node(i, N - 1, heightMap[i][N - 1]));
      visited[i][0] = true;
      visited[i][N - 1] = true;
    }
    for (int i = 1; i < N - 1; i++) {
      queue.add(new Node(0, i, heightMap[0][i]));
      queue.add(new Node(M - 1, i, heightMap[M - 1][i]));
      visited[0][i] = true;
      visited[M - 1][i] = true;
    }
    while (!queue.isEmpty()) {
      Node curr = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nextX = curr.x + dx[i];
        int nextY = curr.y + dy[i];
        if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N || visited[nextX][nextY]) {
          continue;
        }
        visited[nextX][nextY] = true;
        if (curr.h > heightMap[nextX][nextY]) {
          waterSum += curr.h - heightMap[nextX][nextY];
          queue.add(new Node(nextX, nextY, curr.h));
        } else {
          queue.add(new Node(nextX, nextY, heightMap[nextX][nextY]));
        }
      }
    }
    return waterSum;
  }

  private static class Node {
    public int x;
    public int y;
    public int h;

    public Node(int x, int y, int h) {
      this.x = x;
      this.y = y;
      this.h = h;
    }
  }
}
