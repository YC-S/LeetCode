package leetcode500.p04_linked_list.plan2_removal;

public class P19_RemoveNthNodeFromEndOfList {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode slow = head, fast = head;
    ListNode dummy = new ListNode(-1);
    ListNode prev = dummy;
    dummy.next = head;
    for (int i = 0; i < n; i++) {
      fast = fast.next;
    }
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
      prev = prev.next;
    }
    prev.next = slow.next;
    return dummy.next;
  }
}
