package contest.leetcode.单周赛._254;

public class A {
  public static int numOfStrings(String[] patterns, String word) {
    int count = 0;
    for (String pattern : patterns) {
      if (word.contains(pattern)) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    String[] patterns = {"a", "abc", "bc", "d"};
    String[] patterns1 = {"a", "b", "c"};
    String[] patterns2 = {"a", "a", "a"};
    System.out.println(numOfStrings(patterns, "abc"));
    System.out.println(numOfStrings(patterns1, "aaaaabbbbb"));
    System.out.println(numOfStrings(patterns2, "ab"));
  }
}
