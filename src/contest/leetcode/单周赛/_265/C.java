package contest.leetcode.单周赛._265;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class C {
  public static void main(String[] args) {
    System.out.println(new C().minimumOperations(new int[] {2, 8, 16}, 0, 3));
  }

  public int minimumOperations(int[] nums, int start, int goal) {
    int count = 0;
    Queue<Pair> queue = new LinkedList<>();
    queue.offer(new Pair(start, true));
    int step = 0;
    Set<Integer> seen = new HashSet<>();
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Pair cur = queue.poll();
        if (cur.getValue() == goal) {
          return step;
        } else {
          for (int num : nums) {
            if (!seen.contains(cur.getValue() + num)
                && (cur.isValid() || cur.getValue() + num >= 0 && cur.getValue() + num <= 1000)) {
              if (cur.getValue() < 0 || cur.getValue() > 1000) {
                queue.offer(new Pair(cur.getValue() + num, false));
                seen.add(cur.getValue() + num);
              } else {
                queue.offer(new Pair(cur.getValue() + num, true));
                seen.add(cur.getValue() + num);
              }
            }
            if (!seen.contains(cur.getValue() - num)
                && (cur.isValid() || cur.getValue() - num >= 0 && cur.getValue() - num <= 1000)) {
              if (cur.getValue() < 0 || cur.getValue() > 1000) {
                queue.offer(new Pair(cur.getValue() - num, false));
                seen.add(cur.getValue() - num);
              } else {
                queue.offer(new Pair(cur.getValue() - num, true));
                seen.add(cur.getValue() - num);
              }
            }
            if (!seen.contains(cur.getValue() ^ num)
                && (cur.isValid()
                    || (cur.getValue() ^ num) >= 0 && (cur.getValue() ^ num) <= 1000)) {
              if (cur.getValue() < 0 || cur.getValue() > 1000) {
                queue.offer(new Pair(cur.getValue() ^ num, false));
                seen.add(cur.getValue() ^ num);
              } else {
                queue.offer(new Pair(cur.getValue() ^ num, true));
                seen.add(cur.getValue() ^ num);
              }
            }
          }
        }
      }
      step++;
    }
    return -1;
  }

  class Pair {
    int value;
    boolean isValid;

    public Pair(int value, boolean isValid) {
      this.value = value;
      this.isValid = isValid;
    }

    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }

    public boolean isValid() {
      return isValid;
    }

    public void setValid(boolean valid) {
      isValid = valid;
    }
  }
}
