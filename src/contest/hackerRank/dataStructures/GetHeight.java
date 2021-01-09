/*
 * Copyright (c) 2020. Yuanchen
 */

package contest.hackerRank.dataStructures;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/24
 */
public class GetHeight {

    public static int getHeight(Node root) {
        if (root == null) {
            return -1;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n3.left = n2;
        n3.right = n5;
        n2.left = n1;
        n5.left = n4;
        n5.right = n6;
        n6.right = n7;
        System.out.println(getHeight(n3));
    }
}

class Node {

    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }
}