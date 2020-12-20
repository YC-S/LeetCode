/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/29
 */
public class P1380_LuckyNumbersInAMatrix {

    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        // check the index of the smallest number in the first row
        int minIndex = 0;
        for (int[] array : matrix) {
            for (int index = 0; index < array.length; index++) {
                if (array[index] < array[minIndex]) {
                    minIndex = index;
                }
            }
        }
        // find the correct row
        int maxRow = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][minIndex] > matrix[maxRow][minIndex]) {
                maxRow = i;
            }
        }
        // check if the number is the smallest in the result row
    int smallest = matrix[maxRow][minIndex];
    for (int i = 0; i < matrix[maxRow].length; i++) {
      if (matrix[maxRow][i] < smallest) {
        return new ArrayList<>();
      }
    }
    res.add(smallest);
    return res;

  }

  public static void main(String[] args) {
    int[][] matrix = {{36376, 85652, 21002, 4510}, {68246, 64237, 42962, 9974},
      {32768, 97721, 47338, 5841}, {55103, 18179, 79062, 46542}};
    System.out.println(luckyNumbers(matrix));
  }

}
