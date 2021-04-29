package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximizeExpression {
  public int maximizeExpression(int[] array) {
    if (array.length < 4) return 0;
    ArrayList<Integer> maxOfA = new ArrayList<>(Arrays.asList(array[0]));
    ArrayList<Integer> maxOfAMinusB = new ArrayList<>(Arrays.asList(Integer.MIN_VALUE));
    ArrayList<Integer> maxOfAMinusBPlusC =
        new ArrayList<>(Arrays.asList(Integer.MIN_VALUE, Integer.MIN_VALUE));
    ArrayList<Integer> maxOfAMinusBPlusCMinusD =
        new ArrayList<>(Arrays.asList(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE));
    for (int idx = 1; idx < array.length; idx++) {
      int currentMax = Math.max(maxOfA.get(idx - 1), array[idx]);
      maxOfA.add(currentMax);
    }
    for (int idx = 1; idx < array.length; idx++) {
      int currentMax = Math.max(maxOfAMinusB.get(idx - 1), maxOfA.get(idx - 1) - array[idx]);
      maxOfAMinusB.add(currentMax);
    }
    for (int idx = 2; idx < array.length; idx++) {
      int currentMax =
          Math.max(maxOfAMinusBPlusC.get(idx - 1), maxOfAMinusB.get(idx - 1) + array[idx]);
      maxOfAMinusBPlusC.add(currentMax);
    }
    for (int idx = 3; idx < array.length; idx++) {
      int currentMax =
          Math.max(
              maxOfAMinusBPlusCMinusD.get(idx - 1), maxOfAMinusBPlusC.get(idx - 1) - array[idx]);
      maxOfAMinusBPlusCMinusD.add(currentMax);
    }
    return maxOfAMinusBPlusCMinusD.get(array.length - 1);
  }
}
