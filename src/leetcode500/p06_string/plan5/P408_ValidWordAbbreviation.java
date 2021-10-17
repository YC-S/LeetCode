package leetcode500.p06_string.plan5;

public class P408_ValidWordAbbreviation {
  public boolean validWordAbbreviation(String word, String abbr) {
    int i = 0, j = 0;
    int count = 0;
    while (i < word.length() && j < abbr.length()) {
      while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
        if (count == 0 && abbr.charAt(j) == '0') return false;
        count = count * 10 + abbr.charAt(j) - '0';
        j++;
      }
      if (count == 0) {
        if (word.charAt(i) != abbr.charAt(j)) return false;
        i++;
        j++;
      } else {
        i += count;
        count = 0;
      }
    }
    if (j == abbr.length()) {
      return word.length() - i == count;
    }
    return false;
  }
}
