package company.bht;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SlotMachine2 {
    public static int slotWheels(List<String> history) {
        List<List<Integer>> list = new ArrayList<>();
        for (String s : history) {
            char[] arr = s.toCharArray();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                tmp.add(arr[i] - '0');
            }
            Collections.sort(tmp, Collections.reverseOrder());
            list.add(tmp);
        }
        int res = 0;
        for (int j = 0; j < list.get(0).size(); j++) {
            int curMax = 0;
            for (int i = 0; i < list.size(); i++) {
                curMax = Math.max(curMax, list.get(i).get(j));
            }
            res += curMax;
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> history = Arrays.asList("712", "246", "365", "312");
        System.out.println(slotWheels(history));
    }
}
