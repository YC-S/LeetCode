package all_problems;

import java.util.Stack;

public class P1586_BinarySearchTreeIteratorII {
    private final TreeNode dummy = new TreeNode(-1);
    private final Stack<TreeNode> stack = new Stack<>();
    private TreeNode curr = dummy;

    // Init
    public P1586_BinarySearchTreeIteratorII(TreeNode root) {
        this.collectMins(root);
    }

    // If there's no right and there's no node to append to the 'list', there's no next
    public boolean hasNext() {
        return !(curr.right == null && stack.isEmpty());
    }

    // Go forward. If no right, then we're at the end, append next node. Otherwise, just move forward
    public int next() {
        // If there's no next then we must have a node ready in the Stack
        if (curr.right == null) {
            TreeNode next = stack.pop();

            // Discover next mins and unlink
            collectMins(next.right);
            next.right = null;

            // Append to 'list'
            next.left = curr;
            curr.right = next;
        }

        curr = curr.right;

        return curr.val;
    }

    // If the 'list' is empty or we're at the first nodes, there is no prev
    public boolean hasPrev() {
        return (curr != dummy && curr.left != dummy);
    }

    // Go back
    public int prev() {
        curr = curr.left;
        return curr.val;
    }

    // Should only be called once per node
    private void collectMins(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}
