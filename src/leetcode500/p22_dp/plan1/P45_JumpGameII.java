package leetcode500.p22_dp.plan1;

public class P45_JumpGameII {
  public int jump(int[] jump) {
    int jumps = 0, curEnd = 0, curFarthest = 0;
    for (int i = 0; i < jump.length - 1; i++) {
      curFarthest = Math.max(curFarthest, i + jump[i]);
      if (i == curEnd) {
        jumps++;
        curEnd = curFarthest;
      }
    }
    return jumps;
  }
}
