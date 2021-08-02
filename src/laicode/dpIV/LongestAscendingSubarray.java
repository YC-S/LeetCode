package laicode.dpIV;

public class LongestAscendingSubarray {
  public int longest(int[] array) {
    int res = 1;
    int left = 0;
    if (array.length <= 1) return array.length;
    for (int i = 1; i < array.length; i++) {
      if (array[i] > array[i - 1]) res = Math.max(res, i - left + 1);
      else left = i;
    }
    return res;
  }
}
