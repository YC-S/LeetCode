package company.amazon._1003;

import java.util.Arrays;
import java.util.List;

public class Problem2 {
  public static int minMoves(List<Integer> arr) {
    int n = arr.size();
    int zeroFirst = helper1(arr, n);
    int oneFirst = helper2(arr, n);
    return Math.min(zeroFirst, oneFirst);
  }

  private static int helper1(List<Integer> arr, int n) {
    int count = 0;
    int num = 0;
    for (int i = n - 1; i >= 0; i--) {
      if (arr.get(i) == 0) {
        num++;
      } else {
        count += num;
      }
    }
    return count;
  }

  private static int helper2(List<Integer> arr, int n) {
    int count = 0;
    int num = 0;
    for (int i = n - 1; i >= 0; i--) {
      if (arr.get(i) == 1) {
        num++;
      } else {
        count += num;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(minMoves(Arrays.asList(0, 1, 0, 1)));
    System.out.println(minMoves(Arrays.asList(0, 1, 0, 1, 0, 1, 0)));
    System.out.println(minMoves(Arrays.asList(0, 0, 0, 0, 1, 1, 1, 1)));
    System.out.println(minMoves(Arrays.asList(0, 0, 1, 1, 1, 0, 0)));
    System.out.println(minMoves(Arrays.asList(0, 0, 1, 0, 1, 1, 1, 1)));
  }
}
