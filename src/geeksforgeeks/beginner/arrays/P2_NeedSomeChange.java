package geeksforgeeks.beginner.arrays;

public class P2_NeedSomeChange {
  static void swapElements(int[] a, int n) {
    for (int i = 0; i < n - 2; i++) {
      swap(a, i, i + 2);
    }
    for (int i = 0; i < n; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println();
  }

  private static void swap(int[] a, int x, int y) {
    int tmp = a[x];
    a[x] = a[y];
    a[y] = tmp;
  }

  public static void main(String[] args) {
    swapElements(new int[] {1, 2, 3, 4, 5}, 5);
  }
}
