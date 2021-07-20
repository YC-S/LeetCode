package laicode.cross_trainingI;

import java.util.Arrays;

public class ArrayDeduplicationII {
  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(
            new ArrayDeduplicationII()
                .dedup(new int[] {1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 5, 6, 6, 6, 6})));
  }

  public int[] dedup(int[] array) {
    if (array == null || array.length < 3) return array;
    int slow = 1, fast = 2;
    while (fast < array.length) {
      if (array[slow - 1] != array[fast]) {
        array[++slow] = array[fast];
      }
      fast++;
    }
    return Arrays.copyOf(array, slow + 1);
  }
}
