package leetcode500.P14_hybrid_data_structure.plan2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class P380_InsertDeleteGetRandomO1 {
  /** Initialize your data structure here. */
  ArrayList<Integer> list;

  HashMap<Integer, Integer> map;
  Random rand;

  public P380_InsertDeleteGetRandomO1() {
    // do initialize if necessary
    list = new ArrayList<Integer>();
    map = new HashMap<Integer, Integer>();
    rand = new Random();
  }

  // Inserts a value to the set
  // Returns true if the set did not already contain the specified element or false
  //  Insert and Delete both have O(1) average time complexity, and O(N) in the worst-case scenario
  // when the operation exceeds the capacity of currently allocated array/hashmap and invokes space
  // reallocation.
  public boolean insert(int val) {
    if (map.containsKey(val)) {
      return false;
    }

    map.put(val, list.size());
    list.add(val);
    return true;
  }

  // Removes a value from the set
  // Return true if the set contained the specified element or false
  public boolean remove(int val) {
    if (!map.containsKey(val)) {
      return false;
    }

    int index = map.get(val);
    if (index < list.size() - 1) { // not the last one than swap the last one with this val
      int last = list.get(list.size() - 1);
      list.set(index, last);
      map.put(last, index);
    }
    map.remove(val);
    list.remove(list.size() - 1);
    return true;
  }

  // Get a random element from the set
  // time: O(1)
  public int getRandom() {
    return list.get(rand.nextInt(list.size()));
  }
}
