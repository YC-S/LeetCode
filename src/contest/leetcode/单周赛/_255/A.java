package contest.leetcode.单周赛._255;

public class A {
  public static void main(String[] args) {
    System.out.println(new A().findGCD(new int[] {2, 5, 6, 9, 10}));
    System.out.println(new A().findGCD(new int[] {7, 5, 6, 8, 3}));
    System.out.println(new A().findGCD(new int[] {3, 3}));
  }

  public int findGCD(int[] nums) {
    int s = 1001, l = 0, res = 0;
    for (int num : nums) {
      s = Math.min(s, num);
      l = Math.max(l, num);
    }
    return gcd(s, l);
  }

  private int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }
}
