package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.Arrays;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/29
 */
public class P832_FlippingAnImage {

    public static int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length / 2; j++) {
                swap(A[i], j, A[i].length - j - 1);
            }
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 0) {
                    A[i][j] = 1;
                } else {
                    A[i][j] = 0;
                }
                A[i][j] = (A[i][j] == 0) ? 1 : 0;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] input1 = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
    int[][] input2 = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
    int[][] res = flipAndInvertImage(input1);
    int[][] res2 = flipAndInvertImage(input2);
    for (int[] re : res) {
      System.out.println(Arrays.toString(re));
    }
    for (int[] re : res2) {
      System.out.println(Arrays.toString(re));
    }
  }

  public static void swap(int[] array, int a, int b) {
    int c = array[a];
    array[a] = array[b];
    array[b] = c;
  }
}
