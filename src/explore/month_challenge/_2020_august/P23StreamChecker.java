/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.month_challenge._2020_august;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/23
 */
class TrieNode {

  Map<Character, TrieNode> children = new HashMap();
  boolean word = false;
}

class P23StreamChecker {

  TrieNode trie = new TrieNode();
  Deque<Character> stream = new ArrayDeque();

  public P23StreamChecker(String[] words) {
    for (String word : words) {
      TrieNode node = trie;
      String reversedWord = new StringBuilder(word).reverse().toString();
      for (char ch : reversedWord.toCharArray()) {
        if (!node.children.containsKey(ch)) {
          node.children.put(ch, new TrieNode());
        }
        node = node.children.get(ch);
      }
      node.word = true;
    }
  }

  public boolean query(char letter) {
    stream.addFirst(letter);

    TrieNode node = trie;
    for (char ch : stream) {
      if (node.word) {
        return true;
      }
      if (!node.children.containsKey(ch)) {
        return false;
      }
      node = node.children.get(ch);
    }
    return node.word;
  }
}
