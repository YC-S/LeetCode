package leetcode500.p04_linked_list.plan2_removal;

public class P203_RemoveLinkedListElements {
  public ListNode removeElements(ListNode head, int val) {
    if (head == null) return head;
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode prev = dummy;
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
