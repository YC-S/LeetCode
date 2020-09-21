/*
 * Copyright (c) 2020. Yuanchen
 */

package algorithm.chapter1;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/09/20
 */
public class Q1_1_11 {

  public static void main(String[] args) {
    boolean[][] matrix = new boolean[10][10];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (j % 3 == 0) {
          matrix[i][j] = true;
        }
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j] == true ? "*" : " ");
      }
      System.out.println();
    }
  }


}
