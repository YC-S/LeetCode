package laicode.cross_trainingI;

import java.util.Arrays;

public class ArrayDeduplicationIV {
  public static int[] dedup(int[] array) {
    int slow = -1;
    int fast = 0;
    while (fast < array.length) {
      if (slow == -1 || array[slow] != array[fast]) array[++slow] = array[fast];
      else {
        while (fast + 1 < array.length && array[fast + 1] == array[slow]) {
          fast++;
        }
        slow--;
      }
      fast++;
    }
    return Arrays.copyOf(array, slow + 1);
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(dedup(new int[] {1, 2, 3, 3, 3, 2, 2})));
  }
}
