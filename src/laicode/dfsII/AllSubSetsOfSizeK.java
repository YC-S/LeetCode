package laicode.dfsII;

import java.util.ArrayList;
import java.util.List;

public class AllSubSetsOfSizeK {
  public List<String> subSetsOfSizeK(String set, int k) {
    List<String> res = new ArrayList<>();
    if (set == null) return res;
    StringBuilder sb = new StringBuilder();
    char[] array = set.toCharArray();
    helper(array, sb, 0, k, res);
    return res;
  }

  private void helper(char[] array, StringBuilder sb, int index, int k, List<String> res) {
    if (sb.length() == k) {
      res.add(sb.toString());
      return;
    }
    if (index == array.length) {
      return;
    }
    helper(array, sb.append(array[index]), index + 1, k, res);
    sb.deleteCharAt(sb.length() - 1);
    helper(array, sb, index + 1, k, res);
  }
}
