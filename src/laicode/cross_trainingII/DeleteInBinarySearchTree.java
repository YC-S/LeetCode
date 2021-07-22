package laicode.cross_trainingII;

public class DeleteInBinarySearchTree {
  public TreeNode deleteTree(TreeNode root, int key) {
    if (root == null) return null;
    if (root.key == key) {
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      } else if (root.right.left == null) {
        root.right.left = root.left;
        return root.right;
      } else {
        TreeNode newRoot = deleteSmallest(root.right, key);
        newRoot.left = root.left;
        newRoot.right = root.right;
        return newRoot;
      }
    }
    if (root.key < key) {
      root.right = deleteTree(root.right, key);
    }
    if (root.key > key) {
      root.left = deleteTree(root.left, key);
    }
    return root;
  }

  private TreeNode deleteSmallest(TreeNode root, int key) {
    while (root.left.left != null) {
      root = root.left;
    }
    TreeNode smallest = root.left;
    root.left = root.left.right;
    return smallest;
  }
}
