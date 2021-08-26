package geeksforgeeks.beginner.arrays;

public class P999_NeedSomeChange {
  public void swapElements(int[] arr, int n) {
    for (int i = 0; i < n - 2; i++) {
      swap(arr, i, i + 2);
    }
  }

  private void swap(int[] arr, int a, int b) {
    int tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }
}
