package all_problems;

public class P1858_LongestWordWithAllPrefixes {
  Trie root = new Trie();
  String res = "";

  public String longestWord(String[] words) {
    for (String word : words) addWord(word);
    for (String word : words) searchPrefix(word);
    return res;
  }

  private void searchPrefix(String word) {
    Trie cur = root;
    for (char c : word.toCharArray()) {
      cur = cur.children[c];
      if (!cur.isWord) return;
    }
    if (res.length() < word.length() || res.length() == word.length() && res.compareTo(word) > 0)
      res = word;
  }

  private void addWord(String word) {
    Trie cur = root;
    for (char c : word.toCharArray()) {
      if (cur.children[c] == null) cur.children[c] = new Trie();
      cur = cur.children[c];
    }
    cur.isWord = true;
  }

  static class Trie {
    Trie[] children = new Trie[256];
    boolean isWord;
  }
}
