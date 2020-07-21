/*
 * Copyright (c) 2020. Yuanchen
 */

package july_challenge;

import utility.ListNode;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/21
 */
public class P19RemoveLinkedListElements {

  public ListNode removeElements(ListNode head, int val) {
    ListNode dummy = new ListNode(0);
    ListNode prev = dummy;
    dummy.next = head;
    while (head != null) {
      if (head.val == val) {
        prev.next = head.next;
      } else {
        prev = head;
      }
      head = head.next;
    }
    return dummy.next;
  }
}
