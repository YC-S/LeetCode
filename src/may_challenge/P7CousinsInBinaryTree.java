/*
 * Copyright (c) 2020. Yuanchen
 */

package may_challenge;

import utility.TreeNode;

/**
 * @author shiyuanchen
 * @created 2020/05/07
 * @project LeetCode
 */
public class P7CousinsInBinaryTree {

    TreeNode xParent = null;
    TreeNode yParent = null;
    int xDepth = -1;
    int yDepth = -2;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, x, y, 0);
        return xDepth == yDepth && xParent != yParent;
    }

    private void dfs(TreeNode root, TreeNode parent, int x, int y, int depth) {
        if (root == null) {
            return;
        }
        if (x == root.val) {
            xParent = parent;
            xDepth = depth;
        } else if (y == root.val) {
            yParent = parent;
            yDepth = depth;
        } else {
            dfs(root.left, root, x, y, depth + 1);
            dfs(root.right, root, x, y, depth + 1);
        }
    }
}
