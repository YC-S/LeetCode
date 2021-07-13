package book.laioffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P398_AllAnagrams {
  public static List<Integer> allAnagrams(String sh, String lo) {
    if (sh.length() < lo.length()) {
      String tmp = sh;
      sh = lo;
      lo = tmp;
    }
    if (lo.length() == 0) return new ArrayList<>();
    List<String> list = allPermutations(lo);
    Set<String> set = new HashSet<>();
    set.addAll(list);
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i <= sh.length() - lo.length(); i++) {
      if (set.contains(sh.substring(i, i + lo.length()))) {
        res.add(i);
      }
    }
    return res;
  }

  private static List<String> allPermutations(String input) {
    List<String> res = new ArrayList<>();
    char[] array = input.toCharArray();
    helper(array, 0, res);
    return res;
  }

  private static void helper(char[] array, int index, List<String> res) {
    if (index == array.length) {
      res.add(new String(array));
      return;
    }
    Set<Character> set = new HashSet<>();
    for (int i = index; i <= array.length; i++) {
      if (set.add(array[i])) {
        swap(array, i, index);
        helper(array, index + 1, res);
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
    System.out.println(allAnagrams("abcbac", "ab"));
  }
}
