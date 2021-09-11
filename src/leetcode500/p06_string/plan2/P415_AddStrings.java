package leetcode500.p06_string.plan2;

public class P415_AddStrings {
  public static String addStrings(String num1, String num2) {
    int m = num1.length(), n = num2.length();
    int i = m - 1, j = n - 1;
    int carry = 0;
    StringBuilder sb = new StringBuilder();
    while (i >= 0 && j >= 0) {
      int cur = num1.charAt(i) - '0' + num2.charAt(j) - '0' + carry;
      if (cur >= 10) {
        carry = 1;
      } else {
        carry = 0;
      }
      sb.append(cur % 10);
      i--;
      j--;
    }
    while (i >= 0) {
      int cur = num1.charAt(i) - '0' + carry;
      if (cur >= 10) {
        carry = 1;
      } else {
        carry = 0;
      }
      sb.append(cur % 10);
      i--;
    }
    while (j >= 0) {
      int cur = num2.charAt(j) - '0' + carry;
      if (cur >= 10) {
        carry = 1;
      } else {
        carry = 0;
      }
      sb.append(cur % 10);
      j--;
    }
    if (carry != 0) {
      sb.append(1);
    }
    return sb.reverse().toString();
  }
}
