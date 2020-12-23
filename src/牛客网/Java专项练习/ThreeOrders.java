/*
 * Copyright (c) 2020. Yuanchen
 */

package 牛客网.Java专项练习;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/21
 */

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }
}

public class ThreeOrders {

    public static void main(String[] args) {
        ThreeOrders solution = new ThreeOrders();
        TreeNode t1 = new TreeNode();
        t1.val = 1;
        TreeNode t2 = new TreeNode();
        t2.val = 2;
        TreeNode t3 = new TreeNode();
        t3.val = 3;
        t1.left = t2;
        t1.right = t3;
        int[][] res = solution.threeOrders(t1);
        for (int i = 0; i < 3; ++i) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    /**
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders(TreeNode root) {
        // write code here
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        int n = list.size();
        int[][] res = new int[3][n];
        for (int i = 0; i < n; ++i) {
            res[0][i] = list.get(i);
        }
        list.clear();
        inOrder(root, list);
        for (int i = 0; i < n; ++i) {
            res[1][i] = list.get(i);
        }
        list.clear();
        postOrder(root, list);
        for (int i = 0; i < n; ++i) {
            res[2][i] = list.get(i);
        }
        return res;
    }

    private void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    private void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }
}
