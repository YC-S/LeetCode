package all_problems;

public class P1876_SubstringsOfSizeThreeWithDistinctCharacters {
  public int countGoodSubstrings(String s) {
    int res = 0;
    for (int i = 1; i < s.length() - 1; i++) {
      if (s.charAt(i - 1) != s.charAt(i)
          && s.charAt(i + 1) != s.charAt(i)
          && s.charAt(i + 1) != s.charAt(i - 1)) res++;
    }
    return res;
  }
}
