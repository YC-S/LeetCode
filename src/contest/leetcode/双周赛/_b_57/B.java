package contest.leetcode.双周赛._b_57;

import java.util.*;

public class B {
  public static int smallestChair(int[][] times, int targetFriend) {
    int[][] copy = new int[times.length][2];
    for (int i = 0; i < times.length; i++) {
      copy[i] = times[i];
    }
    Arrays.sort(copy, Comparator.comparingInt(a -> a[0]));
    Map<Integer, Integer> map = new HashMap<>();
    int[] prev = copy[0];
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    pq.offer(prev);
    map.put(who(prev, times), 0);

    for (int i = 1; i < copy.length; i++) {
      int[] cur = copy[i];
      prev = pq.peek();
      if (prev[1] <= cur[0]) {
        pq.poll();
        int vacant = map.get(who(prev, times));
        map.remove(who(prev, times));
        map.put(who(cur, times), vacant);
      } else {
        map.put(who(cur, times), map.size());
      }
      pq.offer(cur);
    }
    return map.get(targetFriend);
  }

  public static int who(int[] time, int[][] times) {
    for (int i = 0; i < times.length; i++) {
      if (times[i][0] == time[0] && times[i][1] == time[1]) return i;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[][] times =
        new int[][] {
          {33889, 98676},
          {80071, 89737},
          {44118, 52565},
          {52992, 84310},
          {78492, 88209},
          {21695, 67063},
          {84622, 95452},
          {98048, 98856},
          {98411, 99433},
          {55333, 56548},
          {65375, 88566},
          {55011, 62821},
          {48548, 48656},
          {87396, 94825},
          {55273, 81868},
          {75629, 91467}
        };
    int[][] times2 = {{3, 10}, {1, 5}, {2, 6}};
    System.out.println(smallestChair(times, 6));
    System.out.println(smallestChair(times2, 0));
  }
}
