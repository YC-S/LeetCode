package laicode.cross_trainingI;

public class LowestCommonAncestorII {
  public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
    int l1 = length(one);
    int l2 = length(two);
    if (l1 <= l2) {
      return mergeNode(one, two, l2 - l1);
    } else {
      return mergeNode(two, one, l1 - l2);
    }
  }

  private TreeNodeP mergeNode(TreeNodeP shorter, TreeNodeP longer, int diff) {
    while (diff > 0) {
      longer = longer.parent;
      diff--;
    }
    while (longer != shorter) {
      longer = longer.parent;
      shorter = shorter.parent;
    }
    return longer;
  }

  private int length(TreeNodeP node) {
    int length = 0;
    while (node != null) {
      length++;
      node = node.parent;
    }
    return length;
  }
}
