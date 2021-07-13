package book.laioffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P65_AllPermutationsII {
  public static List<String> permutations(String input) {
    List<String> res = new ArrayList<>();
    char[] array = input.toCharArray();
    helper(array, res, 0);
    return res;
  }

  private static void helper(char[] array, List<String> res, int index) {
    if (index == array.length) {
      res.add(new String(array));
      return;
    }
    Set<Character> set = new HashSet<>();
    for (int i = index; i < array.length; i++) {
      if (set.add(array[i])) {
        swap(array, i, index);
        helper(array, res, index + 1);
        swap(array, i, index);
      }
    }
  }

  private static void swap(char[] array, int a, int b) {
    char tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
  }

  public static void main(String[] args) {
    System.out.println(permutations("abbbc"));
  }
}
