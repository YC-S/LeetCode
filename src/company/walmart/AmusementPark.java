package company.walmart;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class AmusementPark {
  public static int solve(List<Integer> arr, int K) {
    int count = 0;
    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
    for (int i = 0; i < arr.size(); i++) {
      pq.offer(new Pair(arr.get(i), -(arr.size() - i)));
    }
    while (K > 0 && pq.size() != 0) {
      Pair cur = pq.poll();
      int cost = cur.cost;
      int maxNumberOfRide = -cur.maxNumberOfRide;
      int div = K / cost;
      if (div < maxNumberOfRide) {
        count += div;
        break;
      } else {
        count += maxNumberOfRide;
        K -= maxNumberOfRide * cost;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(solve(Arrays.asList(3, 4, 8), 10));
    System.out.println(solve(Arrays.asList(5, 2, 1), 4));
  }

  // 这里有static
  static class Pair {
    int cost;
    int maxNumberOfRide;
    // constructor 写一下
    public Pair(int cost, int maxNumberOfRide) {
      this.cost = cost;
      this.maxNumberOfRide = maxNumberOfRide;
    }
  }
}
