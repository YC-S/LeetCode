package algoexpert;

import java.util.ArrayList;
import java.util.List;

public class FindKthLargestValueInBST {
    private static void inOrderTraverse(BST tree, List<Integer> list) {
        if (tree == null) return;
        inOrderTraverse(tree.left, list);
        list.add(tree.value);
        inOrderTraverse(tree.right, list);
    }

    public int findKthLargestValueInBst(BST tree, int k) {
        // Write your code here.
        List<Integer> list = new ArrayList<Integer>();
        inOrderTraverse(tree, list);
        return list.get(list.size() - k);
    }

    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }
}


