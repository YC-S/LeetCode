package leetcode500.p01_basic_coding.plan1;

public class P171_ExcelSheetColumnNumber {
  public int titleToNumber(String columnTitle) {
    char[] array = columnTitle.toCharArray();
    int res = 0;
    for (char c : array) {
      res = res * 26 + (c - 'A' + 1);
    }
    return res;
  }
}
