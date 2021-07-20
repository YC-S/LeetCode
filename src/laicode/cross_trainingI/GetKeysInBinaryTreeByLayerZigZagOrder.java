package laicode.cross_trainingI;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class GetKeysInBinaryTreeByLayerZigZagOrder {
  public List<Integer> zigZag(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    Deque<TreeNode> deque = new ArrayDeque<>();
    boolean evenLayer = false;
    deque.offerFirst(root);
    while (!deque.isEmpty()) {
      int size = deque.size();
      if (!evenLayer) {
        for (int i = 0; i < size; i++) {
          TreeNode cur = deque.pollFirst();
          res.add(cur.key);
          if (cur.right != null) deque.offerLast(cur.right);
          if (cur.left != null) deque.offerLast(cur.left);
        }
      } else {
        for (int i = 0; i < size; i++) {
          TreeNode cur = deque.pollLast();
          res.add(cur.key);
          if (cur.left != null) deque.offerFirst(cur.left);
          if (cur.right != null) deque.offerFirst(cur.right);
        }
      }
      evenLayer = !evenLayer;
    }
    return res;
  }
}
