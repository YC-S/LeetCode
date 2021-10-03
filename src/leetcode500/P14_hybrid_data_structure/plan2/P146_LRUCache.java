package leetcode500.P14_hybrid_data_structure.plan2;

import java.util.LinkedHashMap;
import java.util.Map;

public class P146_LRUCache {
  int capacity;
  Map<Integer, Integer> map;

  public P146_LRUCache(int capacity) {
    this.capacity = capacity;
    this.map = new LinkedHashMap<>();
  }

  public int get(int key) {
    if (!map.containsKey(key)) return -1;
    makeRecently(key);
    return map.get(key);
  }

  private void makeRecently(int key) {
    int val = map.get(key);
    map.remove(key);
    map.put(key, val);
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      map.put(key, value);
      makeRecently(key);
      return;
    }
    if (map.size() >= this.capacity) {
      int oldestKey = map.keySet().iterator().next();
      map.remove(oldestKey);
    }
    map.put(key, value);
  }
}
