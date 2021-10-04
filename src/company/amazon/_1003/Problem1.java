package company.amazon._1003;

import java.util.Arrays;
import java.util.List;

public class Problem1 {
  public static long countDecreasingRatings(List<Integer> ratings) {
    long count = 0;
    int current = 0;
    for (int i = 0; i < ratings.size(); i++) {
      if (i == 0 || ratings.get(i - 1) - ratings.get(i) == 1) {
        current++;
      } else {
        count += helper(current);
        current = 1;
      }
    }
    count += helper(current);
    return count;
  }

  private static long helper(int n) {
    long sum = 0;
    while (n != 0) {
      sum += n;
      n--;
    }
    return sum;
  }

  public static void main(String[] args) {
    System.out.println(countDecreasingRatings(Arrays.asList(4, 3, 5, 4, 3)));
  }
}
