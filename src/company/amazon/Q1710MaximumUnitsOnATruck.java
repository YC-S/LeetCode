package company.amazon;

import java.util.Arrays;

public class Q1710MaximumUnitsOnATruck {
  public int maximumUnits(int[][] boxTypes, int truckSize) {
    Arrays.sort(boxTypes, (o1, o2) -> o2[1] - o1[1]);
    int curLoad = 0;
    for (int[] curBox : boxTypes) {
      if (truckSize > 0) {
        int num = Math.min(curBox[0], truckSize);
        truckSize -= num;
        curLoad += num * curBox[1];
      }
    }
    return curLoad;
  }
}
