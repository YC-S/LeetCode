package contest.leetcode.单周赛._255;

import java.util.*;

public class B {
  public static void main(String[] args) {
    System.out.println(new B().findDifferentBinaryString(new String[] {"00", "01"}));
  }

  public String findDifferentBinaryString(String[] nums) {
    int n = nums[0].length();
    StringBuilder sb = new StringBuilder();
    Set<String> set = new HashSet<>();
    set.addAll(Arrays.asList(nums));
    List<String> list = new ArrayList<>();
    helper(list, 0, sb, n, set);
    for (String s : list) {
      if (!set.contains(s)) return s;
    }
    return null;
  }

  private void helper(List<String> list, int index, StringBuilder sb, int n, Set<String> set) {
    if (index == n) {
      list.add(sb.toString());
      return;
    }
    sb.append(0);
    helper(list, index + 1, sb, n, set);
    sb.deleteCharAt(sb.length() - 1);
    sb.append(1);
    helper(list, index + 1, sb, n, set);
    sb.deleteCharAt(sb.length() - 1);
  }
}
