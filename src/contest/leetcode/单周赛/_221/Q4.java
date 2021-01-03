package contest.leetcode.单周赛._221;

import java.util.Arrays;

public class Q4 {
    public static int[] maximizeXor(int[] nums, int[][] queries) {
        Trie root = new Trie();
        int[][] q = new int[queries.length][queries[0].length + 1];
        for (int i = 0; i < queries.length; i++) {
            q[i][0] = queries[i][0];
            q[i][1] = queries[i][1];
            q[i][2] = i;
        }
        Arrays.sort(nums);
        Arrays.sort(q, (a, b) -> {
            return a[1] - b[1];
        });
        int[] output = new int[queries.length];
        Arrays.fill(output, -1);
        int p = 0;
        for (int i = 0; i < queries.length; i++) {
            while (p < nums.length && nums[p] <= q[i][1]) {
                insert(root, nums[p]);
                p++;
            }
            Trie curr = root;
            int res = 0;
            if (root.left == null && root.right == null) {
                continue;
            }
            for (int j = 31; j >= 0; j--) {
                if (((1 << j) & q[i][0]) == 0) {
                    if (curr.right != null) {
                        res |= (1 << j);
                        curr = curr.right;
                    } else {
                        curr = curr.left;
                    }
                } else {
                    if (curr.left != null) {
                        res |= (1 << j);
                        curr = curr.left;
                    } else {
                        curr = curr.right;
                    }
                }
            }
            output[q[i][2]] = res;
        }
        return output;
    }

    private static void insert(Trie root, int val) {
        Trie curr = root;
        for (int i = 31; i >= 0; i--) {
            if (((1 << i) & val) == 0) {
                if (curr.left == null) curr.left = new Trie();
                curr = curr.left;
            } else {
                if (curr.right == null) curr.right = new Trie();
                curr = curr.right;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 4, 6, 6, 3};
        int[][] queries = {{12, 4}, {8, 1}, {6, 3}};
        System.out.println(Arrays.toString(maximizeXor(nums, queries)));
    }

    static class Trie {
        Trie left;
        Trie right;
    }
}
