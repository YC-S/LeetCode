package leetcode500.P14_hybrid_data_structure.plan2;

import java.util.HashMap;
import java.util.Map;

public class P460_LFUCache {
  private int capacity;
  private int size;
  private int minFrequency;
  private Map<Integer, Node> cache;
  private Map<Integer, DLL> frequencyMap;

  public P460_LFUCache(int capacity) {
    this.size = 0;
    this.capacity = capacity;
    this.minFrequency = 0;
    this.cache = new HashMap<>();
    this.frequencyMap = new HashMap<>();
  }

  public int get(int key) {
    if (!cache.containsKey(key)) return -1;
    else {
      int val = cache.get(key).value;
      updateNode(cache.get(key));
      return val;
    }
  }

  public void put(int key, int value) {
    if (capacity == 0) return;
    if (cache.containsKey(key)) {
      Node n = cache.get(key);
      n.value = value;
      updateNode(n);
    } else {
      size++;
      if (size > capacity) {
        // get minimum frequency list
        DLL minFreqList = frequencyMap.get(minFrequency);
        Node deleteNode = minFreqList.removeTail();
        cache.remove(deleteNode.key);
        size--;
      }
      minFrequency = 1;
      Node newNode = new Node(key, value);

      DLL curList = frequencyMap.getOrDefault(1, new DLL());
      curList.addNode(newNode);
      frequencyMap.put(1, curList);
      cache.put(key, newNode);
    }
  }

  private void updateNode(Node node) {
    DLL list = frequencyMap.get(node.freq);
    list.removeNode(node);
    if (node.freq == minFrequency && list.size == 0) {
      minFrequency++;
    }
    node.freq++;
    if (!frequencyMap.containsKey(node.freq)) {
      frequencyMap.put(node.freq, new DLL());
    }
    frequencyMap.get(node.freq).addNode(node);
  }

  private static class Node {
    int key, value, freq;
    Node prev, next;

    public Node() {}

    public Node(int key, int val) {
      this.key = key;
      this.value = val;
      this.freq = 1;
    }
  }

  private static class DLL {
    Node head;
    Node tail;
    int size;

    public DLL() {
      this.head = new Node();
      this.tail = new Node();
      head.next = tail;
      tail.prev = head;
    }

    public void addNode(Node node) {
      Node after = head.next;
      after.prev = node;
      node.next = after;
      head.next = node;
      node.prev = head;
      size++;
    }

    public void removeNode(Node node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
      size--;
    }

    /** remove tail node * */
    public Node removeTail() {
      // DO NOT FORGET to check list size
      if (size > 0) {
        Node tailNode = tail.prev;
        removeNode(tailNode);
        return tailNode;
      }
      return null;
    }
  }
}
