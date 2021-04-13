package algoexpert;

import java.util.ArrayList;
import java.util.List;

public class FindSuccessor {
    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        // Write your code here.
        List<BinaryTree> inOrder = new ArrayList<>();
        getInOrder(tree, inOrder);

        for (int i = 0; i < inOrder.size(); i++) {
            BinaryTree cur = inOrder.get(i);
            if (cur != node) {
                continue;
            }
            if (i == inOrder.size() - 1) {
                return null;
            }
            return inOrder.get(i + 1);
        }
        return null;
    }

    public void getInOrder(BinaryTree node, List<BinaryTree> order) {
        if (node == null) {
            return;
        }
        getInOrder(node.left, order);
        order.add(node);
        getInOrder(node.right, order);
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
