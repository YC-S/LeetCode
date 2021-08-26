package geeksforgeeks.beginner.arrays;

public class P1_CountOddEven {
  static void countOddEven(int[] a, int n) {
    int oddCount = 0;
    int evenCount = 0;

    for (int i = 0; i < a.length; i++) {
      if (a[i] % 2 == 0) {
        evenCount++;
      } else {
        oddCount++;
      }
    }
    System.out.print(oddCount + " " + evenCount);
  }

  public static void main(String[] args) {
    countOddEven(new int[] {1, 2, 3, 4, 5}, 5);
    countOddEven(new int[] {1, 6, 18, 7}, 4);
  }
}
