/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.month_challenge._2020_august;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/14
 */
public class P13IteratorForCombination {

  public Deque<String> combinations = new ArrayDeque<String>();
  String characters;
  int n, k;

  public P13IteratorForCombination(String characters, int combinationLength) {
    this.n = characters.length();
    this.k = combinationLength;
    this.characters = characters;
    backtrack(0, new StringBuilder());
  }

  public void backtrack(int first, StringBuilder curr) {
    // if the combination is done
    if (curr.length() == k) {
      combinations.push(curr.toString());
      // speed up by non-constructing combinations
      // with more than k elements
      return;
    }

    for (int i = first; i < n; ++i) {
      // add i into the current combination
      curr.append(characters.charAt(i));
      // use next integers to complete the combination
      backtrack(i + 1, curr);
      // backtrack
      curr.deleteCharAt(curr.length() - 1);
    }
  }

  public String next() {
    return combinations.removeLast();
  }

  public boolean hasNext() {
    return (!combinations.isEmpty());
  }
}
