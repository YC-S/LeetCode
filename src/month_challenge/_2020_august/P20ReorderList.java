/*
 * Copyright (c) 2020. Yuanchen
 */

package month_challenge._2020_august;

import utility.ListNode;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/21
 */
public class P20ReorderList {

  public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }
    ListNode mid = middleNode(head);
    ListNode midNext = mid.next;
    mid.next = null;
    head = merge(head, reverse(midNext));
  }

  private ListNode middleNode(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  private ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }

  private ListNode merge(ListNode one, ListNode two) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (one != null && two != null) {
      cur.next = one;
      one = one.next;
      cur.next.next = two;
      two = two.next;
      cur = cur.next.next;
    }
    if (one == null) {
      cur.next = two;
    }
    if (two == null) {
      cur.next = one;
    }
    return dummy.next;
  }
}
