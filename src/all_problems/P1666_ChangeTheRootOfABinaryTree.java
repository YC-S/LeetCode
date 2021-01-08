package all_problems;

public class P1666_ChangeTheRootOfABinaryTree {
    Node original_root;

    public Node flipBinaryTree(Node root, Node leaf) {
        original_root = root;
        return helper(leaf, null); // the new parent of the leaf node must be null
    }

    public Node helper(Node node, Node new_parent) {
        Node old_parent = node.parent;
        node.parent = new_parent;

        if (node.left == new_parent) node.left = null;
        if (node.right == new_parent) node.right = null;

        if (node == original_root) return node;

        if (node.left != null) node.right = node.left;
        node.left = helper(old_parent, node);

        return node;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
}
