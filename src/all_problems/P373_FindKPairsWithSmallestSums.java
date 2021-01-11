package all_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class P373_FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        if (m == 0 || n == 0) return Collections.emptyList();

        int[] pos = new int[m];
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> {
            return Integer.compare(nums1[a] + nums2[pos[a]], nums1[b] + nums2[pos[b]]);
        });

        for (int i = 0; i < m; i++) q.offer(i);
        List<List<Integer>> res = new ArrayList<>();
        while (!q.isEmpty() && k-- > 0) {
            int p = q.poll();
            List<Integer> ele = new ArrayList<>();
            ele.add(nums1[p]);
            ele.add(nums2[pos[p]]);
            if (pos[p] < n - 1) {
                ++pos[p];
                q.offer(p);
            }
            res.add(ele);
        }
        return res;
    }
}
