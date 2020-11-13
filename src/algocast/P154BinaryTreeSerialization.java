/*
 * Copyright (c) 2020. Yuanchen
 */

package algocast;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/12
 */
public class P154BinaryTreeSerialization {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        List<TreeNode> trees = new ArrayList<>();
        trees.add(root);
        for (int i = 0; i < trees.size(); i++) {
            TreeNode node = trees.get(i);
            if (node != null) {
                trees.add(node.left);
                trees.add(node.right);
            }
        }
        while (trees.get(trees.size() - 1) == null) {
            trees.remove(trees.size() - 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < trees.size() - 1; i++) {
            String str = trees.get(i) == null ? "null" : String.valueOf(trees.get(i).val);
            sb.append(str).append(",");
        }
        return "[" + sb.append(trees.get(trees.size() - 1).val).toString() + "]";
    }

    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        String[] elems = data.substring(1, data.length() - 1).split(",");
        TreeNode[] trees = new TreeNode[elems.length];
        for (int i = 0; i < elems.length; i++) {
            trees[i] = elems[i].equals("null") ? null : new TreeNode(Integer.valueOf(elems[i]));
        }
        int i = 1;
        for (TreeNode tree : trees) {
            if (tree != null) {
                if (i < trees.length) {
                    tree.left = trees[i++];
                }
                if (i < trees.length) {
                    tree.right = trees[i++];
                }
            }
        }
        return trees[0];
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
