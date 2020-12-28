package 牛客网.华为面试.第二轮;

// Java program to implement
// the above approach

import utility.TreeNode;

public class Q3 {

    int max = 0;

    public int farthestNodes(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);  // 左子树最大深度
        int right = maxDepth(root.right);  // 右子树最大深度
        max = Math.max(max, left + right);  // 更新最大深度之和
        return Math.max(left, right) + 1;  // +1 是加根结点
    }
}

