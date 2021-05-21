package algoexpert;

import java.util.Stack;

public class CompareLeafTraversal {
  public boolean compareLeafTraversal(BinaryTree tree1, BinaryTree tree2) {
    Stack<BinaryTree> tree1TraversalStack = new Stack<>();
    tree1TraversalStack.push(tree1);
    Stack<BinaryTree> tree2TraversalStack = new Stack<>();
    tree2TraversalStack.push(tree2);
    while (tree1TraversalStack.size() > 0 && tree2TraversalStack.size() > 0) {
      BinaryTree tree1Leaf = getNextLeafNode(tree1TraversalStack);
      BinaryTree tree2Leaf = getNextLeafNode(tree2TraversalStack);
      if (tree1Leaf.value != tree2Leaf.value) {
        return false;
      }
    }
    return (tree1TraversalStack.size() == 0) && (tree2TraversalStack.size() == 0);
  }

  public BinaryTree getNextLeafNode(Stack<BinaryTree> traversalStack) {
    BinaryTree currentNode = traversalStack.pop();

    while (!isLeafNode(currentNode)) {
      if (currentNode.right != null) {
        traversalStack.push(currentNode.right);
      }
      if (currentNode.left != null) {
        traversalStack.push(currentNode.left);
      }
      currentNode = traversalStack.pop();
    }
    return currentNode;
  }

  public boolean isLeafNode(BinaryTree node) {
    return (node.left == null) && (node.right == null);
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
