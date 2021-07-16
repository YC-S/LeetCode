package book.laioffer;

public class P86_LongestAscendingSubArray {
  public static int longest(int[] array) {
    if (array.length <= 1) return array.length;
    int res = 1;
    int left = 0;
    for (int i = 1; i < array.length; i++) {
      if (array[i] > array[i - 1]) {
        res = Math.max(res, i - left + 1);
      } else {
        left = i;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(longest(new int[] {7, 2, 3, 1, 5, 8, 9, 6}));
  }
}
