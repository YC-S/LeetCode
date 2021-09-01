package leetcode500.p30_randomization.plan1;

import java.util.Random;

public class P384_ShuffleAnArray {
  Random random = new Random();
  private int[] array;
  private int[] original;

  public P384_ShuffleAnArray(int[] nums) {
    array = nums;
    original = nums.clone();
  }

  private int randRange(int min, int max) {
    return random.nextInt(max - min) + min;
  }

  private void swapAt(int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }

  public int[] reset() {
    array = original;
    original = original.clone();
    return original;
  }

  public int[] shuffle() {
    for (int i = 0; i < array.length; i++) {
      swapAt(i, randRange(i, array.length));
    }
    return array;
  }
}
