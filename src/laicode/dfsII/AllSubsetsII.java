package laicode.dfsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsetsII {
  public List<String> subSets(String set) {
    List<String> res = new ArrayList<>();
    if (set == null) return res;
    char[] array = set.toCharArray();
    Arrays.sort(array);
    StringBuilder sb = new StringBuilder();
    helper(array, sb, res, 0);
    return res;
  }

  private void helper(char[] array, StringBuilder sb, List<String> res, int index) {
    if (index == array.length) {
      res.add(sb.toString());
      return;
    }
    helper(array, sb.append(array[index]), res, index + 1);
    sb.deleteCharAt(sb.length() - 1);
    while (index < array.length - 1 && array[index] == array[index + 1]) {
      index++;
    }
    helper(array, sb, res, index + 1);
  }
}
