package company.microsoft;

import utility.TreeNode;

public class GoodNode {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, -10000);
    }

    private int goodNodes(TreeNode root, int ma) {
        if (root == null) return 0;
        int res = root.val >= ma ? 1 : 0;
        res += goodNodes(root.left, Math.max(ma, root.val));
        res += goodNodes(root.right, Math.max(ma, root.val));
        return res;
    }
}
