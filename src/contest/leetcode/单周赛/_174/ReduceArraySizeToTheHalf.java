package contest.leetcode.单周赛._174;

// Given an data_structures.array arr.  You can choose a set of integers and remove all the occurrences of these
// integers in the data_structures.array.
//
// Return the minimum size of the set so that at least half of the integers of the data_structures.array are
// removed.
//
//
//
// Example 1:
//
// Input: arr = [3,3,3,3,5,5,5,2,2,7]
// Output: 2
// Explanation: Choosing {3,7} will make the new data_structures.array [5,5,5,2,2] which has size 5 (i.e equal to
// half of the size of the old data_structures.array).
// Possible sets of size 2 are {3,5},{3,2},{5,2}.
// Choosing set {2,7} is not possible as it will make the new data_structures.array [3,3,3,3,5,5,5] which has size
// greater than half of the size of the old data_structures.array.

// Constraints:
//
// 1 <= arr.length <= 10^5
// arr.length is even.
// 1 <= arr[i] <= 10^5

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class ReduceArraySizeToTheHalf {

  public static int minSetSize(int[] arr) {
    int n = arr.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int value : arr) {
      map.put(value, map.getOrDefault(value, 0) + 1);
    }

    PriorityQueue<Entry<Integer, Integer>> pq =
      new PriorityQueue<>(
        (o1, o2) -> o2.getValue() - o1.getValue());

    int cnt = 0;
    for (int i = 0; i < pq.size(); i++) {
      cnt += pq.poll().getValue();
      if (cnt >= n / 2.0) {
        return i;
      }
    }
    return 1;
  }

  public static void main(String[] args) {

  }
}
