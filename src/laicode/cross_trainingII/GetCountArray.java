package laicode.cross_trainingII;

public class GetCountArray {
  public int[] countArray(int[] array) {
    int[] indexArray = initialIndexArray(array);
    int[] countArray = new int[array.length];
    int[] helper = new int[array.length];
    mergeSort(array, indexArray, countArray, helper, 0, array.length - 1);
    return countArray;
  }

  private int[] initialIndexArray(int[] array) {
    int[] indices = new int[array.length];
    for (int i = 0; i < array.length; i++) {
      indices[i] = i;
    }
    return indices;
  }

  private void mergeSort(
      int[] array, int[] indexArray, int[] countArray, int[] helper, int left, int right) {
    if (left >= right) {
      return;
    }
    int mid = left + (right - left) / 2;
    mergeSort(array, indexArray, countArray, helper, left, mid);
    mergeSort(array, indexArray, countArray, helper, mid + 1, right);
    merge(array, indexArray, countArray, helper, left, mid, right);
  }

  private void merge(
      int[] array, int[] indexArray, int[] countArray, int[] helper, int left, int mid, int right) {
    copyArray(indexArray, helper, left, right);
    int l = left;
    int r = mid + 1;
    int cur = left;
    while (l <= mid) {
      if (r > right || array[helper[l]] <= array[helper[r]]) {
        countArray[helper[l]] += (r - mid - 1);
        indexArray[cur++] = helper[l++];
      } else {
        indexArray[cur++] = helper[r++];
      }
    }
  }

  private void copyArray(int[] indexArray, int[] helper, int left, int right) {
    for (int i = left; i <= right; i++) {
      helper[i] = indexArray[i];
    }
  }
}
