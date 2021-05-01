package company.others.sap;

public class sequenceOf1 {
  public static boolean solve(int[] array) {
    boolean count = false;
    for (int j : array) {
      if (j == 1) {
        count = true;
      } else {
        if (!count) return false;
        count = false;
      }
    }
    return !count;
  }

  public static void main(String[] args) {
    System.out.println(solve(new int[] {0, 0, 0, 1, 1, 1}));
    System.out.println(solve(new int[] {1, 1, 1, 1}));
  }
}
