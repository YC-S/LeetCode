package laicode.dpIV;

public class LongestAscendingSubsequence {
  public int longest(int[] array) {
    if (array.length == 0) return 0;
    int[] tbl = new int[array.length + 1];
    int result = 1;
    tbl[1] = array[0];
    for (int i = 1; i < array.length; i++) {
      int index = find(tbl, 1, result, array[i]);
      if (index == result) tbl[++result] = array[i];
      else tbl[index + 1] = array[i];
    }
    return result;
  }

  private int find(int[] tbl, int left, int right, int target) {
    while (left <= right) {
      int mid = (left + right) >>> 1;
      if (tbl[mid] >= target) right = mid - 1;
      else left = mid + 1;
    }
    return right;
  }
}
