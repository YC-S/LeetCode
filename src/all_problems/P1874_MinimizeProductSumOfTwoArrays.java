package all_problems;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P1874_MinimizeProductSumOfTwoArrays {
  public int minProductSum(int[] nums1, int[] nums2) {
    PriorityQueue<Integer> one = new PriorityQueue<>(Comparator.comparingInt(a -> a));
    PriorityQueue<Integer> two = new PriorityQueue<>(Collections.reverseOrder());
    for (int num : nums1) {
      one.add(num);
    }
    for (int num : nums2) {
      two.add(num);
    }
    int res = 0;
    while (!one.isEmpty() && !two.isEmpty()) {
      res += one.poll() * two.poll();
    }
    return res;
  }
}
