/*
 * Copyright (c) 2020. Yuanchen
 */

package algorithm.chapter1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/09/20
 */
public class Q1_1_13 {

  private static void rotateMatrix(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        queue.offer(matrix[i][j]);
      }
    }
    for (int j = n - 1; j >= 0; j--) {
      for (int i = 0; i < m; i++) {
        matrix[i][j] = queue.poll();
      }
    }
  }

  public static void main(String[] args) {
    int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
    rotateMatrix(matrix);
    for (int i = 0; i < matrix.length; i++) {
      System.out.println(Arrays.toString(matrix[i]));
    }
  }

}
