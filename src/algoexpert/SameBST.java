package algoexpert;

import java.util.List;

public class SameBST {
  public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
    // Write your code here.
    return areSameBsts(arrayOne, arrayTwo, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public static boolean areSameBsts(
      List<Integer> arrayOne,
      List<Integer> arrayTwo,
      int rootIdxOne,
      int rootIdxTwo,
      int minVal,
      int maxVal) {
    if (rootIdxOne == -1 || rootIdxTwo == -1) return rootIdxOne == rootIdxTwo;
    if (arrayOne.get(rootIdxOne).intValue() != arrayTwo.get(rootIdxTwo).intValue()) return false;
    int leftRootIdxOne = getIdxOfFirstSmaller(arrayOne, rootIdxOne, minVal);
    int leftRootIdxTwo = getIdxOfFirstSmaller(arrayTwo, rootIdxTwo, minVal);
    int rightRootIdxOne = getIdxOfFirstBiggerOrEqual(arrayOne, rootIdxOne, maxVal);
    int rightRootIdxTwo = getIdxOfFirstBiggerOrEqual(arrayTwo, rootIdxTwo, maxVal);
    int currentValue = arrayOne.get(rootIdxOne);
    boolean leftAreSame =
        areSameBsts(arrayOne, arrayTwo, leftRootIdxOne, leftRootIdxTwo, minVal, currentValue);
    boolean rightAreSame =
        areSameBsts(arrayOne, arrayTwo, rightRootIdxOne, rightRootIdxTwo, currentValue, maxVal);
    return leftAreSame && rightAreSame;
  }

  public static int getIdxOfFirstSmaller(List<Integer> array, int startingIdx, int minVal) {
    for (int i = startingIdx + 1; i < array.size(); i++) {
      if (array.get(i).intValue() < array.get(startingIdx).intValue()
          && array.get(i).intValue() >= minVal) {
        return i;
      }
    }
    return -1;
  }

  public static int getIdxOfFirstBiggerOrEqual(List<Integer> array, int startingIdx, int maxVal) {
    for (int i = startingIdx + 1; i < array.size(); i++) {
      if (array.get(i).intValue() >= array.get(startingIdx).intValue()
          && array.get(i).intValue() < maxVal) {
        return i;
      }
    }
    return -1;
  }
}
