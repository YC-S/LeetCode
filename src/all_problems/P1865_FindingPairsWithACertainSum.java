package all_problems;

import java.util.HashMap;
import java.util.Map;

public class P1865_FindingPairsWithACertainSum {
  Map<Integer, Integer> map = new HashMap<>();
  int[] nums1, nums2;

  public P1865_FindingPairsWithACertainSum(int[] nums1, int[] nums2) {
    this.nums1 = nums1;
    this.nums2 = nums2;
    for (int num : nums2) map.put(num, map.getOrDefault(num, 0) + 1);
  }

  public void add(int index, int val) {
    map.put(nums2[index], map.get(nums2[index]) - 1);
    nums2[index] += val;
    map.put(nums2[index], map.getOrDefault(nums2[index], 0) + 1);
  }

  public int count(int tot) {
    int result = 0;
    for (int num : nums1) if (map.containsKey(tot - num)) result += map.get(tot - num);
    return result;
  }
}
