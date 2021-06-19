package all_problems;

import java.util.Map;
import java.util.TreeMap;

public class P1902_DepthOfBSTGivenInsertionOrder {
  public int maxDepthBST(int[] order) {
    int n = order.length, maxDepth = 1;

    // our map will associate a value in our BST to its depth
    TreeMap<Integer, Integer> map = new TreeMap<>();
    map.put(order[0], 1);

    for (int i = 1; i < n; i++) {
      int val = order[i];

      // getting left and right next door entries! (and their corresponding depths)
      Map.Entry<Integer, Integer> left = map.ceilingEntry(val);
      Map.Entry<Integer, Integer> right = map.floorEntry(val);
      int leftDepth = 0, rightDepth = 0;

      if (left != null) leftDepth = left.getValue();
      if (right != null) rightDepth = right.getValue();

      // the depth of our value is the highest of the two, plus one (since it's a child)
      int depth = Math.max(leftDepth, rightDepth) + 1;
      maxDepth = Math.max(maxDepth, depth);

      map.put(val, depth);
    }
    return maxDepth;
  }
}
