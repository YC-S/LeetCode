package all_problems;

import java.util.LinkedList;
import java.util.List;

public class P431_EncodeNaryTreeToBinaryTree {
    public TreeNode encode(Node root) {
        if (root == null) {
            return null;
        }
        TreeNode result = new TreeNode(root.val);
        if (root.children.size() > 0) {
            result.left = encode(root.children.get(0));
        }
        TreeNode cur = result.left;
        for (int i = 1; i < root.children.size(); i++) {
            cur.right = encode(root.children.get(i));
            cur = cur.right;
        }
        return result;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (root == null) {
            return null;
        }
        Node result = new Node(root.val, new LinkedList<>());
        TreeNode cur = root.left;
        while (cur != null) {
            result.children.add(decode(cur));
            cur = cur.right;
        }
        return result;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
