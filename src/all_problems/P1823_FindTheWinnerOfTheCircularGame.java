package all_problems;

public class P1823_FindTheWinnerOfTheCircularGame {
  public int findTheWinner(int n, int k) {
    int res = 0;
    for (int i = 1; i <= n; ++i) res = (res + k) % i;
    return res + 1;
  }
}
