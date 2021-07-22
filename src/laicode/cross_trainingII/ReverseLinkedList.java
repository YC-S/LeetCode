package laicode.cross_trainingII;

public class ReverseLinkedList {
  public ListNode reverse(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode prev = null;
    while (head != null && head.next != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }
}
