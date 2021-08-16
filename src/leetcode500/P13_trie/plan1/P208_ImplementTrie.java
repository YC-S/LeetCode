package leetcode500.P13_trie.plan1;

public class P208_ImplementTrie {
  Node root;

  public P208_ImplementTrie() {
    root = new Node();
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    Node temp = root;
    for (char a : word.toCharArray()) {
      if (temp.children[a - 'a'] == null) {
        temp.children[a - 'a'] = new Node();
      }
      temp = temp.children[a - 'a'];
    }
    temp.isWord = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    Node temp = root;
    for (char a : word.toCharArray()) {
      if (temp.children[a - 'a'] == null) {
        return false;
      }
      temp = temp.children[a - 'a'];
    }
    return temp.isWord;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    Node temp = root;
    for (char a : prefix.toCharArray()) {
      if (temp.children[a - 'a'] == null) {
        return false;
      }
      temp = temp.children[a - 'a'];
    }
    return true;
  }
}

class Node {
  Node[] children = new Node[26];
  boolean isWord;
}
