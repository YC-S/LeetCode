package leetcode500.P09_bst.plan1;

public class P510_InorderSuccessorInBSTII {
  public Node inorderSuccessor(Node node) {
    if (node.right != null) {
      node = node.right;
      while (node.left != null) node = node.left;
      return node;
    }
    while (node.parent != null && node == node.parent.right) {
      node = node.parent;
    }
    return node.parent;
  }
}
