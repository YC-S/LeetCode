package all_problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class P1804_ImplementTrieII {
  TrieNode root;

  public P1804_ImplementTrieII() {
    root = new TrieNode();
  }

  public void insert(String word) {
    int n = word.length();
    TrieNode cur = root;
    for (int i = 0; i < n; i++) {
      char ch = word.charAt(i);
      Map<Character, TrieNode> children = cur.children;
      TrieNode child = children.get(ch);
      if (child == null) {
        child = new TrieNode();
        children.put(ch, child);
      }
      child.prefixCnt++;
      cur = child;
    }
    cur.wordCnt++;
  }

  public int countWordsEqualTo(String word) {
    TrieNode cur = root;
    int n = word.length();
    for (int i = 0; i < n; i++) {
      char ch = word.charAt(i);
      Map<Character, TrieNode> children = cur.children;
      TrieNode child = children.get(ch);
      if (child == null) {
        return 0;
      }
      cur = child;
    }
    return cur.wordCnt;
  }

  public int countWordsStartingWith(String prefix) {
    TrieNode cur = root;
    int n = prefix.length();
    for (int i = 0; i < n; i++) {
      char ch = prefix.charAt(i);
      Map<Character, TrieNode> children = cur.children;
      TrieNode child = children.get(ch);
      if (child == null) {
        return 0;
      }
      cur = child;
    }
    return cur.prefixCnt;
  }

  public void erase(String word) {
    Deque<TrieNode> stack = new ArrayDeque<>();
    TrieNode cur = root;
    int n = word.length();
    for (int i = 0; i < n; i++) {
      stack.offerFirst(cur);
      char ch = word.charAt(i);
      Map<Character, TrieNode> children = cur.children;
      cur = children.get(ch);
    }
    cur.wordCnt--;
    for (int i = n - 1; i >= 0; i--) {
      char ch = word.charAt(i);
      // System.out.println(ch);
      TrieNode parent = stack.pollFirst();
      Map<Character, TrieNode> children = parent.children;
      TrieNode child = children.get(ch);
      child.prefixCnt--;
      if (child.prefixCnt == 0) {
        children.remove(ch);
      }
    }
  }

  static class TrieNode {
    Map<Character, TrieNode> children;
    int prefixCnt;
    int wordCnt;

    TrieNode() {
      children = new HashMap<>();
    }
  }
}
