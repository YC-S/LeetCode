package laicode.cross_trainingI;

import java.util.Arrays;

public class ArrayDeduplicationI {
  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(new ArrayDeduplicationI().dedup(new int[] {1, 1, 2, 3, 3, 4, 5, 6})));
  }

  public int[] dedup(int[] array) {
    if (array == null || array.length <= 1) return array;
    int slow = 0, fast = 0;
    while (fast < array.length) {
      if (array[fast] != array[slow]) {
        array[++slow] = array[fast];
      }
      fast++;
    }
    return Arrays.copyOf(array, slow + 1);
  }
}
