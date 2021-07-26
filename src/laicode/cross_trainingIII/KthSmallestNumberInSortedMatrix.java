package laicode.cross_trainingIII;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestNumberInSortedMatrix {
  public int kthSmallest(int[][] matrix, int k) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(c -> c.value));
    boolean[][] visited = new boolean[rows][cols];
    minHeap.offer(new Cell(0, 0, matrix[0][0]));
    visited[0][0] = true;
    for (int i = 0; i < k - 1; i++) {
      Cell cur = minHeap.poll();
      if (cur.row + 1 < rows && !visited[cur.row + 1][cur.col]) {
        minHeap.offer(new Cell(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]));
        visited[cur.row + 1][cur.col] = true;
      }
      if (cur.col + 1 < cols && !visited[cur.row][cur.col + 1]) {
        minHeap.offer(new Cell(cur.row, cur.col + 1, matrix[cur.row][cur.col + 1]));
        visited[cur.row][cur.col + 1] = true;
      }
    }
    return minHeap.peek().value;
  }

  class Cell {
    int row;
    int col;
    int value;

    public Cell(int row, int col, int value) {
      this.row = row;
      this.col = col;
      this.value = value;
    }
  }
}
