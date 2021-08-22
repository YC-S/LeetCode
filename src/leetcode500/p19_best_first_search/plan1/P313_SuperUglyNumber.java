package leetcode500.p19_best_first_search.plan1;

import java.util.PriorityQueue;

public class P313_SuperUglyNumber {
  public int nthSuperUglyNumber(int n, int[] primes) {
    PriorityQueue<Long> q = new PriorityQueue<>();
    int count = 1;
    long num = 1;
    for (int i : primes) {
      q.add((long) i);
    }
    while (count < n) {
      num = q.poll();
      if (q.isEmpty() || num != q.peek()) {
        count++;
        for (int i : primes) {
          q.add(num * i);
        }
      }
    }
    return (int) num;
  }
}
