import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Interval {
    public int start;
    public int end;

    public Interval() {
    }

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
}

public class P759_EmployeeFreeTime {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> intervals = new ArrayList<>();
        for (List<Interval> list : schedule) {
            intervals.addAll(list);
        }
        Collections.sort(intervals, (a, b) -> {
            return a.start - b.start;
        });
        Interval prev = intervals.get(0);
        List<Interval> res = new ArrayList<>();
        for (Interval cur : intervals) {
            if (prev.end < cur.start) {
                res.add(new Interval(prev.end, cur.start));
                prev = cur;
            } else {
                prev.start = Math.min(prev.start, cur.start);
                prev.end = Math.max(prev.end, cur.end);
            }
        }
        return res;

    }
}
