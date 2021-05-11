package algoexpert;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTree {
  public static BinaryTree flattenBinaryTree(BinaryTree root) {
    // Write your code here.
    List<BinaryTree> inOrderNodes = getNodesInOrder(root, new ArrayList<BinaryTree>());
    for (int i = 0; i < inOrderNodes.size() - 1; i++) {
      BinaryTree leftNode = inOrderNodes.get(i);
      BinaryTree rightNode = inOrderNodes.get(i + 1);
      leftNode.right = rightNode;
      rightNode.left = leftNode;
    }
    return inOrderNodes.get(0);
  }

  public static List<BinaryTree> getNodesInOrder(BinaryTree tree, List<BinaryTree> array) {
    if (tree != null) {
      getNodesInOrder(tree.left, array);
      array.add(tree);
      getNodesInOrder(tree.right, array);
    }
    return array;
  }

  // This is the class of the input root. Do not edit it.
  static class BinaryTree {
    int value;
    BinaryTree left = null;
    BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}
