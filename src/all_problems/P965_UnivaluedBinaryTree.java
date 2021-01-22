package all_problems;

public class P965_UnivaluedBinaryTree {
    int val = -1;

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        if (val < 0) val = root.val;
        return root.val == val && isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
