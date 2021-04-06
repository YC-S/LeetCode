package algoexpert;

import java.util.List;

public class MinHeightBST {
    public static BST minHeightBst(List<Integer> array) {
        // Write your code here.
        return helper(array, null, 0, array.size() - 1);
    }

    private static BST helper(List<Integer> array, BST bst, int left, int right) {
        if (right < left) return null;
        int mid = left + (right - left) / 2;
        int val = array.get(mid);
        if (bst == null) bst = new BST(val);
        else bst.insert(val);
        helper(array, bst, left, mid - 1);
        helper(array, bst, mid + 1, right);
        return bst;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
}
