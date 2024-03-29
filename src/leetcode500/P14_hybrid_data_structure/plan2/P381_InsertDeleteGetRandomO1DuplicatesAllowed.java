package leetcode500.P14_hybrid_data_structure.plan2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class P381_InsertDeleteGetRandomO1DuplicatesAllowed {
  ArrayList<Integer> nums;
  HashMap<Integer, Set<Integer>> locs;
  java.util.Random rand = new java.util.Random();
  /** Initialize your data structure here. */
  public P381_InsertDeleteGetRandomO1DuplicatesAllowed() {
    nums = new ArrayList<Integer>();
    locs = new HashMap<Integer, Set<Integer>>();
  }

  /**
   * Inserts a value to the collection. Returns true if the collection did not already contain the
   * specified element.
   */
  public boolean insert(int val) {
    boolean contain = locs.containsKey(val);
    if (!contain) locs.put(val, new LinkedHashSet<Integer>());
    locs.get(val).add(nums.size());
    nums.add(val);
    return !contain;
  }

  /**
   * Removes a value from the collection. Returns true if the collection contained the specified
   * element.
   */
  public boolean remove(int val) {
    boolean contain = locs.containsKey(val);
    if (!contain) return false;
    int loc = locs.get(val).iterator().next();
    locs.get(val).remove(loc);
    if (loc < nums.size() - 1) {
      int lastOne = nums.get(nums.size() - 1);
      nums.set(loc, lastOne);
      locs.get(lastOne).remove(nums.size() - 1);
      locs.get(lastOne).add(loc);
    }
    nums.remove(nums.size() - 1);

    if (locs.get(val).isEmpty()) locs.remove(val);
    return true;
  }

  /** Get a random element from the collection. */
  public int getRandom() {
    return nums.get(rand.nextInt(nums.size()));
  }
}
