package algoexpert;

public class HeightBalancedBinaryTree {
    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        // Write your code here.
        if (tree == null) return true;
        boolean leftB = heightBalancedBinaryTree(tree.left);
        boolean rightB = heightBalancedBinaryTree(tree.right);
        if (!leftB || !rightB) {
            return false;
        }
        int leftHeight = findHeight(tree.left);
        int rightHeight = findHeight(tree.right);
        return Math.abs(leftHeight - rightHeight) <= 1;
    }

    private int findHeight(BinaryTree tree) {
        if (tree == null) return 0;
        int left = findHeight(tree.left);
        int right = findHeight(tree.right);
        return Math.max(left, right) + 1;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
