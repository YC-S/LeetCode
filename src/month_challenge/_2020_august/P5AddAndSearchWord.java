/*
 * Copyright (c) 2020. Yuanchen
 */

package month_challenge._2020_august;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/06
 */
public class P5AddAndSearchWord {

  private static final int R = 26;
  private Node root;

  /**
   * Initialize your data structure here.
   */
  public P5AddAndSearchWord() {
    root = new Node();
  }

  /**
   * Adds a word into the data structure.
   */
  public void addWord(String word) {
    root = insert(word, root, 0);
  }

  private Node insert(String word, Node x, int d) {
    if (x == null) {
      x = new Node();
    }
    if (d == word.length()) {
      x.isEnd = true;
      return x;
    }
    char c = word.charAt(d);
    x.next[c - 'a'] = insert(word, x.next[c - 'a'], d + 1);
    return x;
  }

  /**
   * Returns if the word is in the data structure. A word could contain the dot
   * character '.' to represent any one letter.
   */
  public boolean search(String word) {
    return search(word, root, 0);
  }

  private boolean search(String pat, Node x, int d) {
    if (x == null) {
      return false;
    }
    if (d == pat.length()) {
      return x.isEnd;
    }
    char next = pat.charAt(d);
    boolean ans = false;
    for (char c = 0; c < R; c++) {
      if (next == '.' || c == next - 'a') {
        ans = ans || search(pat, x.next[c], d + 1);
      }
    }
    return ans;
  }

  private static class Node {

    boolean isEnd = false;
    Node[] next = new Node[R];
  }
}
