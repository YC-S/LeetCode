package leetcode500.p04_linked_list.plan4;

public class P369_PlusOneLinkedList {
  public ListNode plusOne(ListNode head) {
    ListNode p = reverse(head);
    ListNode dummy = new ListNode(0);
    ListNode prev = dummy;
    dummy.next = p;
    boolean carry = true;
    while (p != null) {
      if (carry) {
        p.val++;
      }
      if (p.val == 10) {
        p.val = 0;
      } else {
        carry = false;
        break;
      }
      p = p.next;
      prev = prev.next;
    }
    if (carry && p == null) {
      prev.next = new ListNode(1);
    }
    return reverse(dummy.next);
  }

  private ListNode reverse(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode prev = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }
}
