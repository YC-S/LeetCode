/*
 * Copyright (c) 2020. Yuanchen
 */

package algocast;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/12
 */
public class P4IsSymmetric {

    public boolean isSymmetric(TreeNode s, TreeNode t) {
        if (s != null && t != null) {
            return s.val == t.val && isSymmetric(s.left, t.left) && isSymmetric(s.right, t.right);
        } else {
            return s == null && t == null;
        }
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
