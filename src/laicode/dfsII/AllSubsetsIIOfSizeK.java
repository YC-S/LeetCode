package laicode.dfsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsetsIIOfSizeK {
  public List<String> subSetsIIOfSizeK(String set, int k) {
    List<String> res = new ArrayList<>();
    if (set == null) return res;
    char[] array = set.toCharArray();
    Arrays.sort(array);
    StringBuilder sb = new StringBuilder();
    helper(array, k, sb, 0, res);
    return res;
  }

  private void helper(char[] array, int k, StringBuilder sb, int index, List<String> res) {
    if (sb.length() == k) {
      res.add(sb.toString());
      return;
    }
    if (index == array.length) return;
    helper(array, k, sb.append(array[index]), index + 1, res);
    sb.deleteCharAt(sb.length() - 1);
    while (index < array.length - 1 && array[index] == array[index + 1]) {
      index++;
    }
    helper(array, k, sb, index + 1, res);
  }
}
