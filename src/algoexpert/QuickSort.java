package algoexpert;

public class QuickSort {
  public static int[] quickSort(int[] array) {
    // Write your code here.
    quickSort(array, 0, array.length - 1);
    return array;
  }

  public static void quickSort(int[] array, int startIdx, int endIdx) {
    if (startIdx >= endIdx) return;
    int leftIdx = startIdx + 1;
    int rightIdx = endIdx;
    while (rightIdx >= leftIdx) {
      if (array[leftIdx] > array[startIdx] && array[rightIdx] < array[startIdx]) {
        swap(leftIdx, rightIdx, array);
      }
      if (array[leftIdx] <= array[startIdx]) {
        leftIdx += 1;
      }
      if (array[rightIdx] >= array[startIdx]) {
        rightIdx -= 1;
      }
    }
    swap(startIdx, rightIdx, array);
    boolean leftSubarrayIsSmaller = rightIdx - 1 - startIdx < endIdx - (rightIdx + 1);
    if (leftSubarrayIsSmaller) {
      quickSort(array, startIdx, rightIdx - 1);
      quickSort(array, rightIdx + 1, endIdx);
    } else {
      quickSort(array, rightIdx + 1, endIdx);
      quickSort(array, startIdx, rightIdx - 1);
    }
  }

  public static void swap(int i, int j, int[] array) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}
