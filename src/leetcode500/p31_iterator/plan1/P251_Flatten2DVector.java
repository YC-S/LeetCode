package leetcode500.p31_iterator.plan1;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class P251_Flatten2DVector {
  private final List<Integer> nums = new ArrayList<>();
  private int position = 0;

  public P251_Flatten2DVector(int[][] vec) {
    for (int[] innerVector : vec) {
      for (int num : innerVector) {
        nums.add(num);
      }
    }
  }

  public int next() {
    if (!hasNext()) throw new NoSuchElementException();
    int result = nums.get(position);
    position++;
    return result;
  }

  public boolean hasNext() {
    return position < nums.size();
  }
}
