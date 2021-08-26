package geeksforgeeks.beginner.arrays;

public class P10_EvenSubsets {
  static int countSumSubsets(int[] arr, int n) {
    int sl = (int) Math.pow(2, n);
    int count = 0;

    for (int i = 1; i < sl; i++) {
      int sum = 0;
      for (int j = 0; j < n; j++) {
        if ((i & (1 << j)) == 1) {
          sum += arr[j];
        }
      }
      if (sum % 2 == 0) {
        count++;
      }
    }

    return count;
  }
}
