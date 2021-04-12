package algoexpert;

public class ValidateBST {
    public static boolean validateBst(BST tree) {
        return helper(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean helper(BST tree, int minValue, int maxValue) {
        if (tree.value <= minValue || tree.value >= maxValue) return false;
        if (tree.left != null && !helper(tree.left, minValue, tree.value)) return false;
        return tree.right == null || helper(tree.right, tree.value, maxValue);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
