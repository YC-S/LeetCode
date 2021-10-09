package leetcode500.p06_string.plan4;

public class P28_ImplementStrStr {
  public static int strStr(String haystack, String needle) {
    if (haystack.equals(needle)) return 0;
    int m = haystack.length(), n = needle.length();
    int i = 0, j = 0;
    while (i <= m - n) {
      int k = i;
      while (j < needle.length() && haystack.charAt(k) == needle.charAt(j)) {
        k++;
        j++;
      }
      if (j == needle.length()) {
        return i;
      } else {
        j = 0;
      }
      i++;
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(strStr("abc", "c"));
  }
}
