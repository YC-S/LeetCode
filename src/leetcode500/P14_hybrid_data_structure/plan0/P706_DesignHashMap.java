package leetcode500.P14_hybrid_data_structure.plan0;

public class P706_DesignHashMap {
  HashNode[] hashArray;
  int N;

  /** Initialize your data structure here. */
  public P706_DesignHashMap() {
    this.N = 10000;
    hashArray = new HashNode[N];
  }

  /** value will always be non-negative. */
  public void put(int key, int value) {
    // get the index using the key
    int index = getIndex(key);

    // form the new node
    HashNode node = new HashNode(key, value, null);

    // if the index does not have any hash node, add the node directly
    if (hashArray[index] == null) {
      hashArray[index] = node;
    } else {
      // get the node at the index
      HashNode temp = hashArray[index];
      boolean isPresent = false;
      HashNode prev = temp;

      // traverse till last node
      while (temp != null) {
        // if same key already exists then update the value and exit
        if (temp.key == node.key) {
          temp.value = node.value;
          return;
        }
        prev = temp;
        temp = temp.next;
      }
      prev.next = node;
    }
  }

  /**
   * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
   * for the key
   */
  public int get(int key) {
    // get index using the key
    int index = getIndex(key);

    // if the node is not found at that index return -1
    if (hashArray[index] == null) {
      return -1;
    }

    // get the hash node
    HashNode temp = hashArray[index];

    // iterate while you dont find the key
    while (temp.next != null && temp.key != key) {
      temp = temp.next;
    }

    // if last node is reached and still key is not found
    if (temp == null || temp.key != key) {
      return -1;
    }

    return temp.value;
  }

  /** Removes the mapping of the specified value key if this map contains a mapping for the key */
  public void remove(int key) {
    // get the index based on the key
    int index = getIndex(key);

    // get the hash node using the key
    HashNode temp = hashArray[index];

    // if no node found
    if (temp == null) {
      return;
    }
    // if it is the only node
    if (temp.next == null) {
      if (temp.key == key) {
        hashArray[index] = null;
      }
    } else if (temp.key == key) { // if key matches with first node
      hashArray[index] = temp.next;
    } else {
      HashNode prev = temp;
      // else iterate over all nodes until key is found or last node reached
      while (temp != null && temp.key != key) {
        prev = temp;
        temp = temp.next;
      }

      // if last node is reached or key is not found
      if (temp == null || temp.key != key) {
        return;
      }
      prev.next = temp.next;
    }
  }

  public int getIndex(int key) {
    return Integer.hashCode(key) & (N - 1);
  }

  // creating HashNode class
  private static class HashNode {
    int key;
    int value;
    HashNode next;

    HashNode(int k, int v, HashNode nextNode) {
      this.key = k;
      this.value = v;
      this.next = nextNode;
    }
  }
}
