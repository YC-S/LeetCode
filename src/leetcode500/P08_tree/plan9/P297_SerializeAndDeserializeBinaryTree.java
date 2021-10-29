package leetcode500.P08_tree.plan9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P297_SerializeAndDeserializeBinaryTree {
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    return serializeHelper(root, "");
  }

  private String serializeHelper(TreeNode root, String str) {
    if (root == null) {
      str += "null,";
    } else {
      str += root.val + ",";
      str = serializeHelper(root.left, str);
      str = serializeHelper(root.right, str);
    }
    return str;
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    String[] array = data.split(",");
    List<String> list = new ArrayList<>(Arrays.asList(array));
    return deserializeHelper(list);
  }

  private TreeNode deserializeHelper(List<String> list) {
    if (list.get(0).equals("null")) {
      list.remove(0);
      return null;
    }
    TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
    list.remove(0);
    root.left = deserializeHelper(list);
    root.right = deserializeHelper(list);
    return root;
  }
}
