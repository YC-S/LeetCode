package laicode.cross_trainingI;

import java.util.Arrays;

public class LargestAndSmallest {
  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(new LargestAndSmallest().largestAndSmallest(new int[] {2, 1, 5, 4, 3})));
  }

  public int[] largestAndSmallest(int[] array) {
    int n = array.length;
    for (int i = 0; i < n / 2; i++) {
      if (array[i] < array[n - 1 - i]) swap(array, i, n - i - 1);
    }
    return new int[] {largest(array, 0, (n - 1) / 2), smallest(array, n / 2, n - 1)};
  }

  private int largest(int[] array, int left, int right) {
    int largest = array[left];
    for (int i = left + 1; i <= right; i++) {
      largest = Math.max(largest, array[i]);
    }
    return largest;
  }

  private int smallest(int[] array, int left, int right) {
    int smallest = array[left];
    for (int i = left + 1; i <= right; i++) {
      smallest = Math.min(smallest, array[i]);
    }
    return smallest;
  }

  private void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}
