package leetcode500.P14_hybrid_data_structure.plan2;

import java.util.*;

public class P981_TimeBasedKeyValueStore {
  Map<String, List<Pair<Integer, String>>> M;

  public P981_TimeBasedKeyValueStore() {
    M = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    if (!M.containsKey(key)) M.put(key, new ArrayList<Pair<Integer, String>>());

    M.get(key).add(new Pair<>(timestamp, value));
  }

  public String get(String key, int timestamp) {
    if (!M.containsKey(key)) return "";

    List<Pair<Integer, String>> A = M.get(key);
    int i =
        Collections.binarySearch(
            A, new Pair<>(timestamp, "{"), (a, b) -> Integer.compare(a.getKey(), b.getKey()));

    if (i >= 0) return A.get(i).getValue();
    else if (i == -1) return "";
    else return A.get(-i - 2).getValue();
  }

  static class Pair<T1, T2> {
    T1 key;
    T2 value;

    public Pair(T1 key, T2 value) {
      this.key = key;
      this.value = value;
    }

    public T1 getKey() {
      return key;
    }

    public T2 getValue() {
      return value;
    }
  }
}
