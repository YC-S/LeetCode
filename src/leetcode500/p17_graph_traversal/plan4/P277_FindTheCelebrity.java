package leetcode500.p17_graph_traversal.plan4;

import java.util.Random;

public class P277_FindTheCelebrity {
  Random random = new Random();

  boolean knows(int a, int b) {
    return random.nextInt() % 2 == 0;
  }

  public int findCelebrity(int n) {
    int candidate = 0;
    for (int i = 1; i < n; i++) {
      if (knows(candidate, i)) {
        candidate = i;
      }
    }
    for (int i = 0; i < n; i++) {
      if (i != candidate && (!knows(i, candidate) || knows(candidate, i))) return -1;
    }
    return candidate;
  }
}
