package geeksforgeeks.beginner.arrays;

public class P4_MatrixInterchange {
  static void interchange(int[][] a, int r, int c) {

    // Your code here
    for (int i = 0; i < r; i++) {
      swap(a[i], 0, c - 1);
    }

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        System.out.print(a[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void swap(int[] arr, int a, int b) {
    int tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }
}
