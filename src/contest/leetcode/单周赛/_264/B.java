package contest.leetcode.单周赛._264;

public class B {
  public static void main(String[] args) {
    B solution = new B();
    System.out.println(solution.nextBeautifulNumber(1));
    System.out.println(solution.nextBeautifulNumber(1000));
    System.out.println(solution.nextBeautifulNumber(3000));
  }

  public int nextBeautifulNumber(int n) {
    while (true) {
      n++;
      if (balanced(n)) {
        return n;
      }
    }
  }

  private boolean balanced(int n) {
    int[] count = new int[10];
    String tmp = String.valueOf(n);
    char[] array = tmp.toCharArray();
    for (char c : array) {
      count[c - '0']++;
    }
    for (int i = 0; i < count.length; i++) {
      if (count[i] == 0) continue;
      if (count[i] != i) return false;
    }
    return true;
  }
}
