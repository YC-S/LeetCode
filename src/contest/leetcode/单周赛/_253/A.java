package contest.leetcode.单周赛._253;

public class A {
  public static boolean isPrefixString(String s, String[] words) {
    int i = 0;
    for (String word : words) {
      if (i == s.length()) return true;
      for (int j = 0; j < word.length(); j++) {
        if (i >= s.length() || s.charAt(i) != word.charAt(j)) return false;
        else i++;
      }
    }
    return i == s.length();
  }

  public static void main(String[] args) {
    System.out.println(
        isPrefixString("iloveleetcode", new String[] {"i", "love", "leetcode", "apples"}));
    System.out.println(
        isPrefixString(
            "iloveleetcode",
            new String[] {
              "apples", "i", "love", "leetcode",
            }));
    System.out.println(isPrefixString("a", new String[] {"aa", "aaaa", "banana"}));
    System.out.println(isPrefixString("ccccccccc", new String[] {"c", "cc"}));
  }
}
