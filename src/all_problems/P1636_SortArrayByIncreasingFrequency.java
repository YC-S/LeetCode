package all_problems;

import java.util.*;

public class P1636_SortArrayByIncreasingFrequency {
    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b) -> a.getValue() == b.getValue() ? b.getKey() - a.getKey() : a.getValue() - b.getValue());
        int index = 0;
        int[] res = new int[nums.length];
        for (Map.Entry<Integer, Integer> entry : list) {
            int count = entry.getValue();
            int key = entry.getKey();
            for (int i = 0; i < count; i++) {
                res[index++] = key;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3};
        System.out.println(Arrays.toString(frequencySort(nums)));
    }
}
