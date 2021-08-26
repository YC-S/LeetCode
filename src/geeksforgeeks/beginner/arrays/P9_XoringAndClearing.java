package geeksforgeeks.beginner.arrays;

import java.util.Arrays;

public class P9_XoringAndClearing {
  static void printArr(int[] arr, int n) {
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  static void setToZero(int[] arr, int n) {
    Arrays.fill(arr, 0);
  }

  static void xor1ToN(int[] arr, int n) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = arr[i] ^ i;
    }
  }
}
