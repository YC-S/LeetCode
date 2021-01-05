/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.linked_list_101;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/28
 */
public class RotateList {

  public static ListNode rotateLeft(ListNode head, int k) {
    int length = 0;
    ListNode cur1 = head;
    while (cur1 != null) {
      length++;
      cur1 = cur1.next;
    }
    k = k % length;
    ListNode newHead = head;
    ListNode dummyHead = new ListNode(0);
    dummyHead.next = newHead;
    for (int i = 0; i < k; i++) {
      dummyHead = dummyHead.next;
      newHead = newHead.next;
    }
    ListNode cur = newHead;
    while (cur != null && cur.next != null) {
      cur = cur.next;
    }
    ListNode cur2 = head;
    while (cur2 != dummyHead) {
      cur.next = cur2;
      cur = cur.next;
      cur2 = cur2.next;
    }
    dummyHead.next = null;
    return newHead;
  }

  public static void main(String[] args) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    ListNode result = rotateLeft(node1, 2);
    while (result != null) {
      System.out.println(result.val);
      result = result.next;
    }
  }
}
