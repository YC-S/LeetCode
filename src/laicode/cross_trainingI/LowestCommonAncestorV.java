package laicode.cross_trainingI;

public class LowestCommonAncestorV {
  public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, KnaryTreeNode a, KnaryTreeNode b) {
    if (root == null || root == a || root == b) return root;
    KnaryTreeNode found = null;
    for (KnaryTreeNode child : root.children) {
      KnaryTreeNode node = lowestCommonAncestor(child, a, b);
      if (node == null) continue;
      if (found == null) found = node;
      else return root;
    }
    return found;
  }
}
