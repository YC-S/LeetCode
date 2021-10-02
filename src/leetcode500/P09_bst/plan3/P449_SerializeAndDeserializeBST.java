package leetcode500.P09_bst.plan3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P449_SerializeAndDeserializeBST {
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    serializeHelper(root, sb);
    return sb.toString();
  }

  private void serializeHelper(TreeNode root, StringBuilder sb) {
    if (root == null) return;
    sb.append(root.val).append(",");
    serializeHelper(root.left, sb);
    serializeHelper(root.right, sb);
  }

  public TreeNode deserialize(String data) {
    if (data.length() == 0) return null;
    Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
    return deserializeHelper(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private TreeNode deserializeHelper(Queue<String> queue, int lower, int upper) {
    if (queue.isEmpty()) return null;
    int val = Integer.parseInt(queue.peek());
    if (val < lower || val > upper) return null;
    queue.poll();
    TreeNode root = new TreeNode(val);
    root.left = deserializeHelper(queue, lower, val);
    root.right = deserializeHelper(queue, val, upper);
    return root;
  }
}
