/*
 * Copyright (c) 2020. Yuanchen
 */

package month_challenge._2020_august;

import java.util.Arrays;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/02
 */
public class P3DesignHashSet {

  int alpha = 10;
  int m = 5;
  int n = 0;
  Node[] vector = new Node[m];

  /**
   * Initialize your data structure here.
   */
  public P3DesignHashSet() {

  }

  public void add(int key) {
    int bucket = hashFunction(key);
    if (!keyInBucket(key, vector[bucket])) {
      Node node = new Node(key);
      node.next = vector[bucket];
      vector[bucket] = node;
      n++;
      if (n / m >= alpha) {
        expand();
      }
    }
  }

  public void remove(int key) {
    int bucket = hashFunction(key);
    Node slow = null, fast = vector[bucket];
    if (fast != null && fast.num == key) {
      vector[bucket] = fast.next;
      return;
    }
    while (fast != null && fast.num != key) {
      slow = fast;
      fast = fast.next;
    }
    if (fast != null) {
      slow.next = fast.next;
      n--;
    }
  }

  /**
   * Returns true if this set contains the specified element
   */
  public boolean contains(int key) {
    int bucket = hashFunction(key);
    return keyInBucket(key, vector[bucket]);
  }

  private int hashFunction(int key) {
    return key % m;
  }

  private void expand() {
    Node[] oldVec = Arrays.copyOf(vector, m);
    m = m * 2;
    vector = new Node[m];
    n = 0;
    for (Node node : oldVec) {
      Node ptr = node;
      while (ptr != null) {
        add(ptr.num);
        ptr = ptr.next;
      }
    }
  }

  private boolean keyInBucket(int key, Node node) {
    while (node != null) {
      if (node.num == key) {
        return true;
      }
      node = node.next;
    }
    return false;
  }

  private class Node {

    int num;
    Node next;

    public Node(int n) {
      num = n;
    }
  }
}
