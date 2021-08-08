package contest.leetcode.单周赛._253;

import java.util.PriorityQueue;

public class B {
  public static int minStoneSum(int[] piles, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    for (int pile : piles) {
      pq.offer(pile);
    }
    for (int i = 0; i < k; i++) {
      int cur = 0;
      if (!pq.isEmpty()) {
        cur = pq.poll();
        cur = cur - cur / 2;
      }
      pq.offer(cur);
    }
    int res = 0;
    while (!pq.isEmpty()) {
      res += pq.poll();
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(minStoneSum(new int[] {5, 4, 9}, 2));
    System.out.println(minStoneSum(new int[] {4, 3, 6, 7}, 3));
  }
}
