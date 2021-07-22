package laicode.cross_trainingII;

public class SearchInBST {
  public TreeNode search(TreeNode root, int key) {
    if (root == null) return null;
    if (root.key == key) return root;
    if (root.key < key) return search(root.right, key);
    if (root.key > key) return search(root.left, key);
    return null;
  }
}
