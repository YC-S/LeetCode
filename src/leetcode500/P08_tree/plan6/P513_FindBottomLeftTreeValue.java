package leetcode500.P08_tree.plan6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P513_FindBottomLeftTreeValue {
  public int findBottomLeftValue(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    List<Integer> curList = new ArrayList<>();
    while (!queue.isEmpty()) {
      int size = queue.size();
      curList = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode cur = queue.poll();
        curList.add(cur.val);
        if (cur.left != null) queue.offer(cur.left);
        if (cur.right != null) queue.offer(cur.right);
      }
    }
    return curList.get(0);
  }
}
