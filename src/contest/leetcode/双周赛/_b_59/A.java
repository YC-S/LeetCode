package contest.leetcode.双周赛._b_59;

public class A {
  public static int minTimeToType(String word) {
    char[] array = word.toCharArray();
    int sum = 0;
    char prev = 'a';
    char cur;
    for (char c : array) {
      if (prev < c) {
        sum += Math.min(c - prev, Math.abs(c - 26 - prev)) + 1;
      } else if (prev > c) {
        sum += Math.min(prev - c, Math.abs(prev - 26 - c)) + 1;
      } else {
        // type
        sum++;
      }
      prev = c;
    }
    return sum;
  }

  public static void main(String[] args) {
    System.out.println(minTimeToType("abc"));
    System.out.println(minTimeToType("bza"));
    System.out.println(minTimeToType("zjpc"));
  }
}
