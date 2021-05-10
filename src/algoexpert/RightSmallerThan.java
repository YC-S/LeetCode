package algoexpert;

import java.util.ArrayList;
import java.util.List;

public class RightSmallerThan {
  public static List<Integer> rightSmallerThan(List<Integer> array) {
    // Write your code here.
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < array.size(); i++) {
      int count = 0;
      for (int j = i + 1; j < array.size(); j++) {
        if (array.get(j) < array.get(i)) {
          count++;
        }
      }
      list.add(count);
    }
    return list;
  }
}
