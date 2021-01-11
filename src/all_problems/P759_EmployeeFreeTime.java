package all_problems;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class P759_EmployeeFreeTime {
    TreeMap<Integer, Boolean> map = new TreeMap<Integer, Boolean>();

    public P759_EmployeeFreeTime() {

    }

    public void addNum(int val) {
        map.put(val, true);
    }

    public int[][] getIntervals() {

        if (map.isEmpty()) {
            return new int[0][0];
        }

        List<int[]> list = new ArrayList<int[]>();

        int start = map.firstKey();
        int end = map.firstKey();
        int prev = map.firstKey();
        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            int curr = entry.getKey();

            if (curr == prev + 1) {
                end = curr;
            }

            if (curr - prev > 1) {
                int[] arr = new int[]{start, end};
                list.add(arr);
                start = curr;
                end = curr;

            }
            prev = curr;
        }
        list.add(new int[]{start, end});


        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            int[] arr = list.get(i);
            result[i][0] = arr[0];
            result[i][1] = arr[1];
        }
        return result;
    }
}
