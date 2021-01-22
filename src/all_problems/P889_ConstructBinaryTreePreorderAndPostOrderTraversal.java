package all_problems;

public class P889_ConstructBinaryTreePreorderAndPostOrderTraversal {
    int preIndex = 0, posIndex = 0;

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        TreeNode root = new TreeNode(pre[preIndex++]);
        if (root.val != post[posIndex])
            root.left = constructFromPrePost(pre, post);
        if (root.val != post[posIndex])
            root.right = constructFromPrePost(pre, post);
        posIndex++;
        return root;
    }
}
