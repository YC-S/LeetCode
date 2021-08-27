package leetcode500.p25_intervals.plan1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class P759_EmployeeFreeTime {
  public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
    List<Interval> res = new ArrayList<>();
    PriorityQueue<Interval> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.start));
    schedule.forEach(e -> pq.addAll(e));
    Interval tmp = pq.poll();
    while (!pq.isEmpty()) {
      if (tmp.end < pq.peek().start) {
        res.add(new Interval(tmp.end, pq.peek().start));
        tmp = pq.poll();
      } else {
        tmp = tmp.end < pq.peek().end ? pq.peek() : tmp;
        pq.poll();
      }
    }
    return res;
  }
}
