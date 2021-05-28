package all_problems;

public class P1871_JumpGameVII {
  public boolean canReach(String s, int minJump, int maxJump) {
    int n = s.length(), pre = 0;
    boolean[] dp = new boolean[n];
    dp[0] = true;
    for (int i = 1; i < n; i++) {
      if (i >= minJump && dp[i - minJump]) pre++;
      if (i > maxJump && dp[i - maxJump - 1]) pre--;
      dp[i] = pre > 0 && s.charAt(i) == '0';
    }
    return dp[n - 1];
  }
}
