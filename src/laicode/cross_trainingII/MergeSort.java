package laicode.cross_trainingII;

public class MergeSort {
  public int[] mergeSort(int[] array) {
    if (array == null || array.length < 2) return array;
    int[] helper = new int[array.length];
    mergeSort(array, helper, 0, array.length - 1);
    return array;
  }

  public void mergeSort(int[] array, int[] helper, int left, int right) {
    if (left >= right) return;
    int mid = (left + right) >>> 1;
    mergeSort(array, helper, left, mid);
    mergeSort(array, helper, mid + 1, right);
    merge(array, helper, left, mid, right);
  }

  public void merge(int[] array, int[] helper, int left, int mid, int right) {
    for (int i = left; i <= right; i++) {
      helper[i] = array[i];
    }
    int i = left, j = mid + 1, k = left;
    while (i <= mid && j <= right) {
      if (helper[i] < helper[j]) {
        array[k++] = helper[i++];
      } else {
        array[k++] = helper[j++];
      }
    }
    while (i <= mid) {
      array[k++] = helper[i++];
    }
  }
}
