/*
 * Copyright (c) 2020. Yuanchen
 */

package hackerRank.dataStructures;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/25
 */
public class LinkedList {

    public static Node removeDuplicates(Node head) {
        //Write your code here
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next = head.next;
        while (next != null) {
            if (cur.data == next.data) {
                cur.next = next.next;
                next = cur.next;
            } else {
                cur = next;
                next = next.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

    }

    static class Node {

        Node next;
        int data;
    }
}


