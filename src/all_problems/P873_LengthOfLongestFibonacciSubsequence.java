package all_problems;

import java.util.HashSet;
import java.util.Set;

public class P873_LengthOfLongestFibonacciSubsequence {
    public int lenLongestFibSubseq(int[] arr) {
        Set<Integer> s = new HashSet<Integer>();
        for (int x : arr) s.add(x);
        int res = 2;
        for (int i = 0; i < arr.length; ++i)
            for (int j = i + 1; j < arr.length; ++j) {
                int a = arr[i], b = arr[j], l = 2;
                while (s.contains(a + b)) {
                    b = a + b;
                    a = b - a;
                    l++;
                }
                res = Math.max(res, l);
            }
        return res > 2 ? res : 0;
    }
}
