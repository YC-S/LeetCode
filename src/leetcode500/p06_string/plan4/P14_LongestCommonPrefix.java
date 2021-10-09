package leetcode500.p06_string.plan4;

public class P14_LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 1) return strs[0];
    int minLength = Integer.MAX_VALUE;
    for (String str : strs) {
      minLength = Math.min(minLength, str.length());
    }
    String tmp = strs[0];
    int res = Integer.MAX_VALUE;
    for (int i = 1; i < strs.length; i++) {
      int j = 0;
      String cur = strs[i];
      while (j < minLength) {
        if (cur.charAt(j) == tmp.charAt(j)) {
          j++;
        } else {
          break;
        }
      }
      res = Math.min(res, j);
    }
    return tmp.substring(0, res);
  }
}
