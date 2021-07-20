package laicode.cross_trainingI;

import java.util.Arrays;

public class ArrayDeduplicationIII {
  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(
            new ArrayDeduplicationIII()
                .dedup(new int[] {1, 1, 1, 2, 2, 3, 4, 5, 6, 7, 7, 7, 8, 9})));
  }

  public int[] dedup(int[] array) {
    if (array == null || array.length < 2) return array;
    int slow = 0, fast = 1;
    boolean flag = false;
    while (fast < array.length) {
      if (array[slow] == array[fast]) {
        flag = true;
      } else if (flag == true) {
        array[slow] = array[fast];
        flag = false;
      } else {
        array[++slow] = array[fast];
      }
      fast++;
    }
    return Arrays.copyOf(array, flag ? slow : slow + 1);
  }
}
