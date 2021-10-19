package leetcode500.P16_dfs.plan5;

import java.util.ArrayList;
import java.util.List;

public class P679_24Game {
  public boolean judgePoint24(int[] nums) {
    List<Double> list = new ArrayList<>();
    for (int num : nums) list.add((double) num);
    return solve(list);
  }

  private boolean solve(List<Double> list) {
    if (list.size() == 0) return false;
    if (list.size() == 1) return Math.abs(list.get(0) - 24) < 1e-6;

    for (int i = 0; i < list.size(); i++) {
      for (int j = 0; j < list.size(); j++) {
        if (i != j) {
          List<Double> nums2 = new ArrayList<>();
          for (int k = 0; k < list.size(); k++) {
            if (k != i && k != j) {
              nums2.add(list.get(k));
            }
          }
          for (int k = 0; k < 4; k++) {
            if (k < 2 && j > i) continue;
            if (k == 0) nums2.add(list.get(i) + list.get(j));
            if (k == 1) nums2.add(list.get(i) * list.get(j));
            if (k == 2) nums2.add(list.get(i) - list.get(j));
            if (k == 3) {
              if (list.get(j) != 0) {
                nums2.add(list.get(i) / list.get(j));
              } else {
                continue;
              }
            }
            if (solve(nums2)) return true;
            nums2.remove(nums2.size() - 1);
          }
        }
      }
    }
    return false;
  }
}
