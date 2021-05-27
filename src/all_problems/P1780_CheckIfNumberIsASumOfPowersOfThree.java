package all_problems;

public class P1780_CheckIfNumberIsASumOfPowersOfThree {
  public boolean checkPowersOfThree(int n) {
    while (n > 1 && n % 3 != 2) {
      if (n % 3 == 0) {
        n /= 3;
      } else {
        n--;
      }
    }
    return n == 1;
  }
}
