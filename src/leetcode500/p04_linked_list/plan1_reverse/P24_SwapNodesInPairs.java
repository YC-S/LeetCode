package leetcode500.p04_linked_list.plan1_reverse;

public class P24_SwapNodesInPairs {
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode newHead = head.next;
    head.next = swapPairs(head.next.next);
    newHead.next = head;
    return newHead;
  }
}
