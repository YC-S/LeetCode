package contest.leetcode.单周赛._262;

import java.util.*;

public class A {
  public static void main(String[] args) {
    A solution = new A();
    System.out.println(
        solution.twoOutOfThree(new int[] {1, 1, 3, 2}, new int[] {2, 3}, new int[] {3}));
  }

  public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    Arrays.sort(nums3);
    int i = 0, j = 0, k = 0;
    Set<Integer> set = new HashSet<>();
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] == nums2[j]) {
        set.add(nums1[i]);
        i++;
        j++;
      } else if (nums1[i] < nums2[j]) {
        i++;
      } else {
        j++;
      }
    }
    i = 0;
    j = 0;
    while (i < nums1.length && k < nums3.length) {
      if (nums1[i] == nums3[k]) {
        set.add(nums1[i]);
        i++;
        k++;
      } else if (nums1[i] < nums3[k]) {
        i++;
      } else {
        k++;
      }
    }
    i = 0;
    k = 0;
    while (j < nums2.length && k < nums3.length) {
      if (nums2[j] == nums3[k]) {
        set.add(nums2[j]);
        j++;
        k++;
      } else if (nums2[j] < nums3[k]) {
        j++;
      } else {
        k++;
      }
    }
    return new ArrayList<>(set);
  }
}
