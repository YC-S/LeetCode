package laicode.cross_trainingII;

import java.util.Arrays;
import java.util.List;

public class AnalyzingArrays {
  public static int solve(List<Integer> arr) {
    int max = Integer.MIN_VALUE;
    int maxIndex = -1;
    for (int i = 0; i < arr.size() - 2; i++) {
      int cur = (int) Math.pow(arr.get(i), arr.get(i + 1)) % (1_000_000_007);
      if (cur > max) {
        max = cur;
        maxIndex = i + 1;
      }
    }
    int cur = arr.get(arr.size() - 1);
    if (cur > max) {
      maxIndex = arr.size() - 1;
    }

    return maxIndex;
  }

  public static void main(String[] args) {
    List<Integer> arr = Arrays.asList(3, 5, 4, 2);
    System.out.println(solve(arr));
  }
}
