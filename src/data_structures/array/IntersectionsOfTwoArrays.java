package data_structures.array;

// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2,2]

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [4,9]
public class IntersectionsOfTwoArrays {
  public static int[] intersect(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
      return intersect(nums2, nums1);
    }
    Map<Integer, Integer> map = new HashMap<>();
    for (int n : nums1) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }
    int k = 0;
    for (int n : nums2) {
      int cnt = map.getOrDefault(n, 0);
      if (cnt > 0) {
        nums1[k++] = n;
        map.put(n, cnt - 1);
      }
    }
    return Arrays.copyOfRange(nums1, 0, k);
  }

  public static void main(String[] args) {
    int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
    int[] res = intersect(nums1, nums2);
    System.out.println(Arrays.toString(res));
  }
}
