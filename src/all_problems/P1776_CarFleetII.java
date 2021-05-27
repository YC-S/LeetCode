package all_problems;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class P1776_CarFleetII {
  public double[] getCollisionTimes(int[][] cars) {
    int n = cars.length;
    double[] res = new double[n];
    Arrays.fill(res, -1.0);

    // as soon as a car c1 catches another car c2, we can say c1 vanishes into c2; meaning that
    // after catching c2, we may view c1 as non-exist (cars before c1 may not catches c1);

    Deque<Integer> stack = new LinkedList<>();
    for (int i = n - 1; i >= 0; i--) {
      int[] c1 = cars[i];
      while (!stack.isEmpty()) {
        int j = stack.peekLast();
        int[] c2 = cars[j];

        if (c1[1] > c2[1] && (res[j] == -1.0 || catchTime(cars, i, j) <= res[j])) {
          res[i] = catchTime(cars, i, j);
          break;
        }

        stack.pollLast();
      }
      stack.offerLast(i);
    }
    return res;
  }

  // time for cars[i] to catch cars[j]
  private double catchTime(int[][] cars, int i, int j) {
    int dist = cars[j][0] - cars[i][0];
    int v = cars[i][1] - cars[j][1];

    return (double) dist / v;
  }
}
