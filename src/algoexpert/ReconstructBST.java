package algoexpert;

import java.util.List;

public class ReconstructBST {
    public BST reconstructBst(List<Integer> preOrderTraversalValues) {
        // Write your code here.
        if (preOrderTraversalValues.size() == 0) {
            return null;
        }
        int curVal = preOrderTraversalValues.get(0);
        int rightSubtreeRootIdx = preOrderTraversalValues.size();

        for (int idx = 1; idx < preOrderTraversalValues.size(); idx++) {
            int value = preOrderTraversalValues.get(idx);
            if (value >= curVal) {
                rightSubtreeRootIdx = idx;
                break;
            }
        }

        BST leftSubtree = reconstructBst(preOrderTraversalValues.subList(1, rightSubtreeRootIdx));
        BST rightSubtree = reconstructBst(preOrderTraversalValues.subList(rightSubtreeRootIdx, preOrderTraversalValues.size()));
        BST bst = new BST(curVal);
        bst.left = leftSubtree;
        bst.right = rightSubtree;
        return bst;
    }

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }
}
