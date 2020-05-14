/*
 * Copyright (c) 2020. Yuanchen
 */

package may_challenge;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/05/14
 */
public class P14Trie {

    class Node {

        Node[] children = new Node[26];
        boolean isWord;
    }

    class Trie {

        /**
         * Initialize your data structure here.
         */
        Node root;

        public Trie() {
            root = new Node();
        }

        /**
         * Inserts a word into the trie.
         */
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

        /**
         * Returns if the word is in the trie.
         */
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

        /**
         * Returns if there is any word in the trie that starts with the given
         * prefix.
         */
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

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */
}
