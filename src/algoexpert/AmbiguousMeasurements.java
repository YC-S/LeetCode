package algoexpert;

import java.util.HashMap;

public class AmbiguousMeasurements {
  public boolean ambiguousMeasurements(int[][] measuringCups, int low, int high) {
    // Write your code here.
    HashMap<String, Boolean> memoization = new HashMap<>();
    return canMeasureInRange(measuringCups, low, high, memoization);
  }

  public boolean canMeasureInRange(
      int[][] measuringCups, int low, int high, HashMap<String, Boolean> memoization) {
    String memoizeKey = createHashableKey(low, high);
    if (memoization.containsKey(memoizeKey)) {
      return memoization.get(memoizeKey);
    }
    if (low <= 0 && high <= 0) {
      return false;
    }

    boolean canMeasure = false;
    for (int[] cup : measuringCups) {
      int cupLow = cup[0];
      int cupHigh = cup[1];
      if (low <= cupLow && cupHigh <= high) {
        canMeasure = true;
        break;
      }
      int newLow = Math.max(0, low - cupLow);
      int newHigh = Math.max(0, high - cupHigh);
      canMeasure = canMeasureInRange(measuringCups, newLow, newHigh, memoization);
      if (canMeasure) break;
    }
    memoization.put(memoizeKey, canMeasure);
    return canMeasure;
  }

  public String createHashableKey(int low, int high) {
    return low + ":" + high;
  }
}
