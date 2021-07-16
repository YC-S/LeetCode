package book.laioffer;

public class P87_MaxProductOfCuttingRope {
  public static int maxProduct(int length) {
    int[] array = new int[length + 1];
    array[0] = 0;
    array[1] = 1;
    for (int i = 2; i < array.length; i++) {
      for (int j = 1; j <= i / 2; j++) {
        array[i] = Math.max(array[i], Math.max(j, array[j]) * Math.max(i - j, array[i - j]));
      }
    }
    return array[length];
  }

  public static void main(String[] args) {
    System.out.println(maxProduct(5));
  }
}
