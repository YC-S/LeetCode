package contest.leetcode.单周赛._251;

import java.util.HashSet;
import java.util.Set;

public class B {
  public static String maximumNumber(String num, int[] change) {
    char[] array = num.toCharArray();
    int[] arr = new int[array.length];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = array[i] - '0';
    }
    Set<Integer> set = new HashSet<>();
    for (int c : change) set.add(c);
    boolean notMeet = true; // not meet the largest
    int startIndex = 0;
    for (int i = 0; i < arr.length; i++) {
      int cur = arr[i];
      if (cur < change[cur]) {
        arr[i] = change[cur];
        startIndex = i;
        break;
      }
    }

    for (int i = startIndex + 1; i < arr.length; i++) {
      int cur = arr[i];
      if (cur <= change[cur]) {
        arr[i] = change[cur];
      } else {
        break;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i : arr) {
      sb.append(i);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(maximumNumber("303", new int[] {8, 1, 6, 1, 8, 4, 9, 5, 9, 3}));
    System.out.println(maximumNumber("132", new int[] {9, 8, 5, 0, 3, 6, 4, 2, 6, 8}));
    System.out.println(maximumNumber("214010", new int[] {6, 7, 9, 7, 4, 0, 3, 4, 4, 7}));
  }
}
