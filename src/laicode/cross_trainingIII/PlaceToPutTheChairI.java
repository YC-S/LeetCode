package laicode.cross_trainingIII;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PlaceToPutTheChairI {
  public List<Integer> putChair(char[][] gym) {
    List<Integer> res = new ArrayList<>();
    int m = gym.length;
    int n = gym[0].length;
    int[][] sumMatrix = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (gym[i][j] == 'E') {
          bestBFS(i, j, gym, sumMatrix);
        }
      }
    }
    int globalMin = Integer.MAX_VALUE;
    int tempX = -1;
    int tempY = -1;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (gym[i][j] == 'C' && globalMin > sumMatrix[i][j]) {
          tempX = i;
          tempY = j;
          globalMin = sumMatrix[i][j];
        }
      }
    }
    res.add(tempX);
    res.add(tempY);
    return res;
  }

  private void bestBFS(int x, int y, char[][] gym, int[][] sumMatrix) {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    Deque<Pair> pq = new LinkedList<>();
    boolean[][] visited = new boolean[gym.length][gym[0].length];
    pq.offer(new Pair(x, y));
    visited[x][y] = true;
    int step = 1;
    while (!pq.isEmpty()) {
      int size = pq.size();
      for (int j = 0; j < size; j++) {
        Pair node = pq.poll();
        for (int i = 0; i < 4; i++) {
          int newX = node.x + dx[i];
          int newY = node.y + dy[i];
          if (!isValid(newX, newY, gym, visited)) {
            continue;
          }
          Pair neighbour = new Pair(newX, newY);
          pq.offer(neighbour);
          visited[newX][newY] = true;
          sumMatrix[newX][newY] += step;
        }
      }
      step++;
    }
  }

  private boolean isValid(int i, int j, char[][] gym, boolean[][] visited) {
    return i >= 0
        && j >= 0
        && i < gym.length
        && j < gym[0].length
        && gym[i][j] != 'O'
        && !visited[i][j];
  }

  class Pair {
    int x;
    int y;

    public Pair(int i, int j) {
      this.x = i;
      this.y = j;
    }
  }
}
