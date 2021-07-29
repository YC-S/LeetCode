package laicode.dfsII;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationsOfSubsets {
  public List<String> allPermutationsOfSubsets(String set) {
    List<String> res = new ArrayList<>();
    if (set == null) return res;
    char[] array = set.toCharArray();
    helper(array, 0, res);
    return res;
  }

  private void helper(char[] array, int index, List<String> res) {
    res.add(new String(array, 0, index));
    for (int i = index; i < array.length; i++) {
      swap(array, index, i);
      helper(array, index + 1, res);
      swap(array, index, i);
    }
  }

  private void swap(char[] array, int a, int b) {
    char tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
  }
}
