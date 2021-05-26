package all_problems;

public class P1764_FromArrayByConcatenatingSubArraysOfAnotherArray {
  public boolean canChoose(int[][] groups, int[] nums) {
    int i = 0;
    for (int start = 0; i < groups.length && groups[i].length + start <= nums.length; start++) {
      if (search(groups[i], nums, start)) start += groups[i++].length - 1;
    }
    return i == groups.length;
  }

  private boolean search(int[] group, int[] nums, int start) {
    for (int i = 0; i < group.length; i++) {
      if (group[i] != nums[i + start]) return false;
    }
    return true;
  }
}
