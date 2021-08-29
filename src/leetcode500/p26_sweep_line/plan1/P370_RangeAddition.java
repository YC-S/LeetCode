package leetcode500.p26_sweep_line.plan1;

public class P370_RangeAddition {
  public int[] getModifiedArray(int length, int[][] updates) {
    int[] array = new int[length];
    for (int[] update : updates) {
      int start = update[0];
      int end = update[1];
      int val = update[2];
      array[start] += val;
      if (end < length - 1) array[end + 1] -= val;
    }
    for (int i = 1; i < length; i++) {
      array[i] += array[i - 1];
    }
    return array;
  }
}
