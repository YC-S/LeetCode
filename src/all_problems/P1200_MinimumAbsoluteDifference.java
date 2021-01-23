package all_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1200_MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> listData = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (min == (arr[i] - arr[i - 1])) {
                listData.add(new ArrayList<>(Arrays.asList(arr[i - 1], arr[i])));
            } else if ((min > (arr[i] - arr[i - 1]))) {
                listData.clear();
                listData.add(new ArrayList<>(Arrays.asList(arr[i - 1], arr[i])));
                min = (arr[i] - arr[i - 1]);
            }
        }
        return listData;
    }
}
