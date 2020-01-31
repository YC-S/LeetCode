package array;

// Example 1:
// Input: [1,2,3]
// Output: [1,2,4]
// Explanation: The array represents the integer 123.

import java.util.Arrays;

// Example 2:
// Input: [4,3,2,1]
// Output: [4,3,2,2]
// Explanation: The array represents the integer 4321.
public class PlusOne {
  public static int[] plusOne(int[] digits) {
    int n = digits.length;
    int cnt9 = 0;
    for (int digit : digits) {
      if (digit == 9) {
        cnt9++;
      }
    }
    if (cnt9 == n) {
      int[] res = new int[n + 1];
      res[0] = 1;
      return res;
    }

    boolean add = true;
    for (int i = n - 1; i >= 0; i--) {
      if (add) {
        digits[i]++;
        add = false;
      }
      if (digits[i] == 10) {
        digits[i] = 0;
        add = true;
      }
    }
    return digits;
  }

  public static void main(String[] args) {
    int[] digits = {1,2,3};
    int[] digits2 = {1,2,9};
    int[] digits3 = {1,9,9};
    int[] digits4 = {9,9,9};
    int[] digits5 = {9};
    System.out.println(Arrays.toString(plusOne(digits)));
    System.out.println(Arrays.toString(plusOne(digits2)));
    System.out.println(Arrays.toString(plusOne(digits3)));
    System.out.println(Arrays.toString(plusOne(digits4)));
    System.out.println(Arrays.toString(plusOne(digits5)));
  }
}
