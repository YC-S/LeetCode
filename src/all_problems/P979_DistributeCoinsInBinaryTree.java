package all_problems;

public class P979_DistributeCoinsInBinaryTree {
    int res = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left), right = dfs(root.right);
        res += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }
}
