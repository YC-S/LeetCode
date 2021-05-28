package all_problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class P1825_FindingMKAverage {
  TreeMap<Integer, Integer> top = new TreeMap<>(),
      middle = new TreeMap<>(),
      bottom = new TreeMap<>();
  Queue<Integer> q = new LinkedList<>();
  long middleSum;
  int m, k;
  int countTop, countBottom;

  public P1825_FindingMKAverage(int m, int k) {
    this.m = m;
    this.k = k;
  }

  public void addElement(int num) {
    if (q.size() == m) {
      int pop = q.poll();
      if (top.containsKey(pop)) { // delete item in top, if present
        remove(top, pop);
        countTop--;
      } else if (middle.containsKey(pop)) { // delete item in bottom, if present
        remove(middle, pop);
        middleSum -= pop;
      } else { // delete item in bottom, if present
        remove(bottom, pop);
        countBottom--;
      }
    }
    // insert to middle first
    add(middle, num);
    q.offer(num);
    middleSum += num;
    // move item from middle to top, to fill k slots
    while (countTop < k && !middle.isEmpty()) {
      countTop++;
      middleSum -= middle.lastKey();
      add(top, remove(middle, middle.lastKey()));
    }
    // rebalance middle and top
    while (!middle.isEmpty() && !top.isEmpty() && top.firstKey() < middle.lastKey()) {
      middleSum += top.firstKey();
      add(middle, remove(top, top.firstKey()));
      middleSum -= middle.lastKey();
      add(top, remove(middle, middle.lastKey()));
    }
    // move item from middle to bottom, to fill k slots
    while (countBottom < k && !middle.isEmpty()) {
      countBottom++;
      middleSum -= middle.firstKey();
      add(bottom, remove(middle, middle.firstKey()));
    }
    // rebalance middle and bottom
    while (!middle.isEmpty() && !bottom.isEmpty() && bottom.lastKey() > middle.firstKey()) {
      middleSum += bottom.lastKey();
      add(middle, remove(bottom, bottom.lastKey()));
      middleSum -= middle.firstKey();
      add(bottom, remove(middle, middle.firstKey()));
    }
  }

  private int remove(TreeMap<Integer, Integer> tm, int num) {
    tm.put(num, tm.get(num) - 1);
    if (tm.get(num) == 0) tm.remove(num);
    return num;
  }

  private void add(TreeMap<Integer, Integer> tm, int num) {
    tm.put(num, tm.getOrDefault(num, 0) + 1);
  }

  public int calculateMKAverage() {
    return q.size() == m ? (int) (middleSum / (m - 2 * k)) : -1;
  }
}
