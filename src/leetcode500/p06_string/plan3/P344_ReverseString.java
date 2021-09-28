package leetcode500.p06_string.plan3;

public class P344_ReverseString {
  public void reverseString(char[] s) {
    int i = 0, j = s.length - 1;
    while (i < j) {
      char tmp = s[i];
      s[i] = s[j];
      s[j] = tmp;
      i++;
      j--;
    }
  }
}
