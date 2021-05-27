package all_problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P1792_MaximumAveragePassRatio {
  public double maxAverageRatio(int[][] classes, int extraStudents) {
    PriorityQueue<double[]> heap =
        new PriorityQueue<double[]>(
            new Comparator<double[]>() {
              @Override
              public int compare(double[] o1, double[] o2) {
                return Double.compare(o2[0], o1[0]);
              }
            });
    for (int[] cl : classes) {
      double delta = profit(cl[0], cl[1]);
      heap.offer(new double[] {delta, cl[0], cl[1]});
    }

    while (extraStudents >= 1) {
      double[] temp = heap.poll();
      if (temp != null) {
        double pass = temp[1] + 1, total = temp[2] + 1;
        double delta = profit(pass, total);
        heap.offer(new double[] {delta, pass, total});
        extraStudents--;
      }
    }

    double average = 0d;
    while (!heap.isEmpty()) {
      double[] temp = heap.poll();
      average += temp[1] / temp[2];
    }

    return average / classes.length;
  }

  // O(1)
  public double profit(double a, double b) {
    return (a + 1) / (b + 1) - a / b;
  }
}
