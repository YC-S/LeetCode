package leetcode500.P16_dfs.plan3;

import java.util.ArrayList;
import java.util.List;

public class P784_LetterCasePermutation {
  public static void main(String[] args) {
    P784_LetterCasePermutation solution = new P784_LetterCasePermutation();
    System.out.println(solution.letterCasePermutation("a1b2"));
  }

  public List<String> letterCasePermutation(String s) {
    char[] array = s.toCharArray();
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    dfs(array, res, 0);
    return res;
  }

  private void dfs(char[] array, List<String> res, int index) {
    if (index == array.length) {
      res.add(new String(array));
      return;
    }
    if (Character.isLetter(array[index])) {
      array[index] = Character.toLowerCase(array[index]);
      dfs(array, res, index + 1);
      array[index] = Character.toUpperCase(array[index]);
    }
    dfs(array, res, index + 1);
  }
}
