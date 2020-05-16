/*
 * Copyright (c) 2020. Yuanchen
 */

package may_challenge;

import utility.ListNode;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/05/16
 */
public class P16OddEvenLinkedList {

  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode odd = head, even = head.next;
    ListNode evenDummy = even;
    while (even != null && even.next != null) {
      odd.next = even.next;
      odd = odd.next;
      even.next = even.next.next;
      even = even.next;
    }
    odd.next = evenDummy;
    return head;
  }
}
