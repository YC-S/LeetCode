package contest.leetcode.单周赛._257;

import java.util.Arrays;
import java.util.Comparator;

public class B {

  public static int numberOfWeakCharacters(int[][] properties) {
    Arrays.sort(properties, Comparator.comparingInt(o -> o[0]));
    int count = 0;
    boolean[] array = new boolean[properties.length];
    for (int i = 1; i < properties.length; i++) {
      for (int j = 0; j < properties.length && j < i; j++) {
        if (properties[i][0] > properties[j][0] && properties[i][1] > properties[j][1]) {
          array[j] = true;
        }
      }
    }
    for (boolean b : array) {
      if (b) count++;
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(numberOfWeakCharacters(new int[][] {{5, 5}, {6, 3}, {3, 6}}));
    System.out.println(numberOfWeakCharacters(new int[][] {{2, 2}, {3, 3}}));
    System.out.println(numberOfWeakCharacters(new int[][] {{1, 5}, {10, 4}, {4, 3}}));
    System.out.println(
        numberOfWeakCharacters(
            new int[][] {
              {7, 7}, {1, 2}, {9, 7}, {7, 3}, {3, 10}, {9, 8}, {8, 10}, {4, 3}, {1, 5}, {1, 5}
            }));
    System.out.println(
        numberOfWeakCharacters(new int[][] {{7, 9}, {10, 7}, {6, 9}, {10, 4}, {7, 5}, {7, 10}}));
  }
}
