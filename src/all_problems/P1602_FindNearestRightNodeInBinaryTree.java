package all_problems;

public class P1602_FindNearestRightNodeInBinaryTree {
    TreeNode res;
    Integer depth;

    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        preorder(root, u, 0);
        return res;
    }

    private void preorder(TreeNode root, TreeNode find, int curDepth) {
        if (root == null) return;
        if (root == find) depth = curDepth;
        else if (depth != null && curDepth == depth && res == null) res = root;
        else {
            preorder(root.left, find, curDepth + 1);
            preorder(root.right, find, curDepth + 1);
        }
    }
}
