/*
 * Copyright (c) 2020. Yuanchen
 */

package month_challenge._2020_april;

/**
 * @author shiyuanchen
 * @created 2020/04/29
 * @project LeetCode
 */

public class P29BinaryTreeMaximumPathSum {

    int maxValue;

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
