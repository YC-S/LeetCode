package laicode.dpIV;

public class MaxProductOfCuttingRope {
  public int maxProduct(int length) {
    int[] array = new int[length + 1];
    array[1] = 0;
    for (int i = 2; i < array.length; i++) {
      for (int j = 1; j <= i / 2; j++) {
        array[i] = Math.max(array[i], Math.max(j, array[j]) * Math.max(i - j, array[i - j]));
      }
    }
    return array[length];
  }
}
