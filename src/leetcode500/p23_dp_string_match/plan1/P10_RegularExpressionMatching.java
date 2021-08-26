package leetcode500.p23_dp_string_match.plan1;

public class P10_RegularExpressionMatching {
  public boolean isMatch(String s, String p) {
    if (s == null || p == null) {
      return false;
    }

    boolean[][] memo = new boolean[s.length()][p.length()]; // 记忆搜索结果
    boolean[][] visited = new boolean[s.length()][p.length()]; // 标记是否访问

    return isMatchHelper(s, 0, p, 0, memo, visited);
  }

  private boolean isMatchHelper(
      String s, int sIndex, String p, int pIndex, boolean[][] memo, boolean[][] visited) {
    // "" == ""
    if (pIndex == p.length()) { // 如果p已经匹配完毕
      return sIndex == s.length(); // 根据s是否匹配完毕即可
    }

    if (sIndex == s.length()) { // 如果s匹配完毕
      return isEmpty(p, pIndex);
    }

    if (visited[sIndex][pIndex]) {
      return memo[sIndex][pIndex];
    }

    char sChar = s.charAt(sIndex);
    char pChar = p.charAt(pIndex);
    boolean match;

    // consider a* as a bundle
    if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') { // 如果为'*'，有两种方案
      match =
          isMatchHelper(s, sIndex, p, pIndex + 2, memo, visited)
              || // '*'不去匹配字符
              charMatch(sChar, pChar)
                  && isMatchHelper(s, sIndex + 1, p, pIndex, memo, visited); // '*'重复前面一个字符去匹配s
    } else {
      match =
          charMatch(sChar, pChar)
              && // 如果当前两字符匹配
              isMatchHelper(s, sIndex + 1, p, pIndex + 1, memo, visited); // 继续下一个字符匹配
    }

    visited[sIndex][pIndex] = true; // 搜索完成就标记
    memo[sIndex][pIndex] = match; // 存储搜索结果
    return match;
  }

  private boolean charMatch(char sChar, char pChar) { // 判断两字符是否匹配
    return sChar == pChar || pChar == '.';
  }

  private boolean isEmpty(String p, int pIndex) { // 形如"x*x*"形式
    for (int i = pIndex; i < p.length(); i += 2) {
      if (i + 1 >= p.length() || p.charAt(i + 1) != '*') { // 如果不是'*'，无法匹配
        return false;
      }
    }
    return true;
  }
}
