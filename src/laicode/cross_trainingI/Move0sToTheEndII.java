package laicode.cross_trainingI;

import java.util.Arrays;

public class Move0sToTheEndII {
  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(
            new Move0sToTheEndII()
                .moveZero(new int[] {1, 1, 1, 1, 0, 0, 1, 1, 1, 10, 0, 0, 2, 1, 0})));
  }

  public int[] moveZero(int[] array) {
    if (array == null || array.length < 2) return array;
    int i = 0, j = 0, k = 0;
    while (j < array.length) {
      if (array[j] != 0) {
        array[i++] = array[j];
      }
      j++;
    }
    k = i;
    while (k < array.length) {
      array[i++] = 0;
      k++;
    }
    return array;
  }

  private void swap(int[] array, int a, int b) {
    int tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
  }
}
