package leetcode500.P14_hybrid_data_structure.plan0;

import java.util.Arrays;

public class P705_DesignHashSet {
  int alpha = 10;
  int m = 5;
  int n = 0;
  Node[] vector = new Node[m];
  /** Initialize your data structure here. */
  public P705_DesignHashSet() {}

  public void add(int key) {
    int bucket = hashFunction(key);
    if (!keyInBucket(key, vector[bucket])) {
      Node node = new Node(key);
      node.next = vector[bucket];
      vector[bucket] = node;
      n++;
      if (n / m >= alpha) expand();
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

  /** Returns true if this set contains the specified element */
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
    for (int i = 0; i < oldVec.length; i++) {
      Node ptr = oldVec[i];
      while (ptr != null) {
        add(ptr.num);
        ptr = ptr.next;
      }
    }
  }

  private boolean keyInBucket(int key, Node node) {
    while (node != null) {
      if (node.num == key) return true;
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
