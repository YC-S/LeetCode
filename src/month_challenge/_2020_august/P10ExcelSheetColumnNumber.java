/*
 * Copyright (c) 2020. Yuanchen
 */

package month_challenge._2020_august;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/12
 */
public class P10ExcelSheetColumnNumber {

  public int titleToNumber(String s) {
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      result = result * 26 + (s.charAt(i) - 'A' + 1);
    }
    return result;
  }
}
