package leetcode500.P14_hybrid_data_structure.plan2;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class P1146_SnapshotArray {
  int n, snapId;
  Map<Integer, TreeMap<Integer, Integer>> map;

  public P1146_SnapshotArray(int length) {
    map = new HashMap<>();
    n = length;
    snapId = 0;
  }

  public void set(int index, int val) {
    map.putIfAbsent(index, new TreeMap<>());
    map.get(index).put(snapId, val);
  }

  public int snap() {
    int res = snapId;
    ++snapId;
    return res;
  }

  public int get(int index, int snap_id) {
    if (!map.containsKey(index)) {
      return 0; // no change in the value since beginning
    }

    TreeMap<Integer, Integer> snapshots = map.get(index);
    Map.Entry<Integer, Integer> floorEntry = snapshots.floorEntry(snap_id);
    if (floorEntry == null) {
      return 0;
    }
    return floorEntry.getValue();
  }
}
