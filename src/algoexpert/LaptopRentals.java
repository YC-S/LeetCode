package algoexpert;

import java.util.ArrayList;
import java.util.Collections;

public class LaptopRentals {
  public int laptopRentals(ArrayList<ArrayList<Integer>> times) {
    // Write your code here.
    if (times.size() == 0) return 0;
    int usedLaptops = 0;
    ArrayList<Integer> startTimes = new ArrayList<>();
    ArrayList<Integer> endTimes = new ArrayList<>();

    for (ArrayList<Integer> interval : times) {
      startTimes.add(interval.get(0));
      endTimes.add(interval.get(1));
    }

    Collections.sort(startTimes);
    Collections.sort(endTimes);

    int startIterator = 0;
    int endIterator = 0;

    while (startIterator < times.size()) {
      if (startTimes.get(startIterator) >= endTimes.get(endIterator)) {
        usedLaptops -= 1;
        endIterator += 1;
      }
      usedLaptops += 1;
      startIterator += 1;
    }
    return usedLaptops;
  }
}
