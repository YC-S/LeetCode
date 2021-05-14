package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
  public static List<Integer> longestIncreasingSubsequence(int[] array) {
    int[] sequences = new int[array.length];
    int[] indices = new int[array.length + 1];
    Arrays.fill(indices, Integer.MIN_VALUE);
    int length = 0;
    for (int i = 0; i < array.length; i++) {
      int num = array[i];
      int newLength = binarySearch(1, length, indices, array, num);
      sequences[i] = indices[newLength - 1];
      indices[newLength] = i;
      length = Math.max(length, newLength);
    }
    return buildSequence(array, sequences, indices[length]);
  }

  public static int binarySearch(int startIdx, int endIdx, int[] indices, int[] array, int num) {
    if (startIdx > endIdx) {
      return startIdx;
    }
    int middleIdx = (startIdx + endIdx) / 2;
    if (array[indices[middleIdx]] < num) {
      startIdx = middleIdx + 1;
    } else {
      endIdx = middleIdx - 1;
    }
    return binarySearch(startIdx, endIdx, indices, array, num);
  }

  public static List<Integer> buildSequence(int[] array, int[] sequences, int currentIdx) {
    List<Integer> sequence = new ArrayList<>();
    while (currentIdx != Integer.MIN_VALUE) {
      sequence.add(0, array[currentIdx]);
      currentIdx = sequences[currentIdx];
    }
    return sequence;
  }
}
