package laicode.cross_trainingII;

import java.util.Random;

public class QuickSort {
  Random random = new Random();

  public int[] quickSort(int[] array) {
    if (array == null || array.length < 2) return array;
    quickSort(array, 0, array.length - 1);
    return array;
  }

  private void quickSort(int[] array, int left, int right) {
    if (left >= right) return;
    int pivotIdx = random.nextInt(right - left + 1) + left;
    swap(array, pivotIdx, right);
    int i = left, j = right - 1;
    while (i <= j) {
      if (array[i] < array[j]) {
        i++;
      } else {
        swap(array, i, j--);
      }
    }
    swap(array, i, right);
    quickSort(array, left, i - 1);
    quickSort(array, i + 1, right);
  }

  private void swap(int[] array, int a, int b) {
    int tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
  }
}
