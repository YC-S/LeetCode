package geeksforgeeks.beginner.arrays;

public class P5_PredictTheColumn {
  static int columnWithMaxZero(int[][] a, int n) {
    int[] arr = new int[n];
    for (int j = 0; j < a[0].length; j++) {
      int count = 0;
      for (int i = 0; i < a.length; i++) {
        if (a[i][j] == 0) count++;
      }
      arr[j] = count;
    }
    int max = -1;
    int maxCol = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
        maxCol = i;
      }
    }
    return maxCol;
  }
}
