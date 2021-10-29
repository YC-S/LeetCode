package leetcode500.P08_tree.plan9;

public class P331_VerifyPreorderSerializationOfABinaryTree {
  public boolean isValidSerialization(String preorder) {
    // number of available slots
    int slots = 1;

    for (String node : preorder.split(",")) {
      // one node takes one slot
      --slots;

      // no more slots available
      if (slots < 0) return false;

      // non-empty node creates two children slots
      if (!node.equals("#")) slots += 2;
    }

    // all slots should be used up
    return slots == 0;
  }
}
