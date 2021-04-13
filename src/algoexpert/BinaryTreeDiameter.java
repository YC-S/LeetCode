package algoexpert;

public class BinaryTreeDiameter {
    public int binaryTreeDiameter(BinaryTree tree) {
        // Write your code here.
        return getTreeInfo(tree).diameter;
    }

    public TreeInfo getTreeInfo(BinaryTree tree) {
        if (tree == null) return new TreeInfo(0, 0);
        TreeInfo left = getTreeInfo(tree.left);
        TreeInfo right = getTreeInfo(tree.right);
        int longestPath = left.height + right.height;
        int maxDiameter = Math.max(left.diameter, right.diameter);
        int curDiameter = Math.max(longestPath, maxDiameter);
        int curHeight = 1 + Math.max(left.height, right.height);
        return new TreeInfo(curDiameter, curHeight);
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class TreeInfo {
        public int diameter;
        public int height;

        public TreeInfo(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }
}
