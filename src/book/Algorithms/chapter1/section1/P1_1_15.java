package book.Algorithms.chapter1.section1;

import java.util.HashMap;
import java.util.Map;

public class P1_1_15 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 3, 4, 4, 5, 6, 7, 7, 7, 8};
        System.out.println(histogram(arr));
    }

    private static Map<Integer, Integer> histogram(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return map;
    }
}
