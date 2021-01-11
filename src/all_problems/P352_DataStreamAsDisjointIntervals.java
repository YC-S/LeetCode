package all_problems;

import java.util.*;

public class P352_DataStreamAsDisjointIntervals {
    HashMap<Integer, Integer> map;
    HashMap<Integer, Integer> Intervals;

    /**
     * Initialize your data structure here.
     */
    public P352_DataStreamAsDisjointIntervals() {
        map = new HashMap<>();
        Intervals = new HashMap<>();
    }

    public void addNum(int val) {
        if (map.containsKey(val))
            return;
        else {
            map.put(val, 1);
            if (map.containsKey(val + 1) && map.containsKey(val - 1)) {
                int l = map.get(val + 1);
                int r = map.get(val - 1);
                map.put(val + l, l + r + 1);
                map.put(val - r, l + r + 1);
                Intervals.remove(val + 1);
                Intervals.put(val - r, l + r + 1);
            } else if (map.containsKey(val + 1)) {
                int l = map.get(val + 1);
                map.put(val + l, l + 1);
                map.put(val, l + 1);
                Intervals.remove(val + 1);
                Intervals.put(val, l + 1);
            } else if (map.containsKey(val - 1)) {
                int r = map.get(val - 1);
                map.put(val - r, r + 1);
                map.put(val, r + 1);
                Intervals.put(val - r, r + 1);
            } else
                Intervals.put(val, 1);
        }
    }

    public List<Interval> getIntervals() {
        List<Interval> list = new ArrayList<>();
        for (Integer i : Intervals.keySet())
            list.add(new Interval(i, i + Intervals.get(i) - 1));
        Collections.sort(list, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        return list;
    }
}
