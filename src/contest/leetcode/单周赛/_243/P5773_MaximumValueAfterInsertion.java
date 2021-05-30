package contest.leetcode.单周赛._243;

public class P5773_MaximumValueAfterInsertion {
  public static String maxValue(String n, int x) {
    StringBuilder sb = new StringBuilder();
    boolean appendedX = false;
    if (n.charAt(0) == '-') {
      for (char c : n.toCharArray()) {
        if (c - '0' > x && !appendedX) {
          sb.append(x);
          appendedX = true;
        }
        sb.append(c);
      }
    } else {
      for (char c : n.toCharArray()) {
        if (c - '0' < x && !appendedX) {
          sb.append(x);
          appendedX = true;
        }
        sb.append(c);
      }
    }
    if (!appendedX) sb.append(x);
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(maxValue("28824579515", 8));
  }
}
