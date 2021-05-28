package all_problems;

public class P1822_SignOfTheProductOfAnArray {
  public int arraySign(int[] nums) {
    int sign = 1;
    for (int n : nums) {
      if (n == 0) {
        return 0;
      } else if (n < 0) {
        sign = -sign;
      }
    }
    return sign;
  }
}
