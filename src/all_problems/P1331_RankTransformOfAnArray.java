package all_problems;

import java.util.Arrays;
import java.util.HashMap;

public class P1331_RankTransformOfAnArray {
    public int[] arrayRankTransform(int[] arr) {
        int[] A = Arrays.copyOf(arr, arr.length);
        Arrays.sort(A);
        HashMap<Integer, Integer> rank = new HashMap<>();
        for (int x : A)
            rank.putIfAbsent(x, rank.size() + 1);
        for (int i = 0; i < arr.length; ++i)
            A[i] = rank.get(arr[i]);
        return A;
    }
}
