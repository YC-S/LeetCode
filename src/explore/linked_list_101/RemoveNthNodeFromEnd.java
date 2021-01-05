/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.linked_list_101;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/27
 */
public class RemoveNthNodeFromEnd {

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null || head.next == null) {
      return null;
    }
    ListNode slow = head;
    ListNode fast = head;
    for (int i = 0; i < n; i++) {
      fast = fast.next;
    }
    if (fast != null && fast.next == null) {
      slow.next = null;
      return slow;
    }
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }
    slow.next = fast;
    return head;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
//    head.next.next.next = new ListNode(4);
//    head.next.next.next.next = new ListNode(5);
    ListNode result = removeNthFromEnd(head, 1);
    while (result != null) {
      System.out.println(result.val);
      result = result.next;
    }
  }
}
