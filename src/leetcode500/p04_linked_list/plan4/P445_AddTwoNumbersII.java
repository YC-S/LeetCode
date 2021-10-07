package leetcode500.p04_linked_list.plan4;

public class P445_AddTwoNumbersII {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode p1 = reverse(l1);
    ListNode p2 = reverse(l2);
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    int val = 0;
    while (p1 != null || p2 != null || val != 0) {
      if (p1 != null) {
        val += p1.val;
        p1 = p1.next;
      }
      if (p2 != null) {
        val += p2.val;
        p2 = p2.next;
      }
      cur.next = new ListNode(val % 10);
      val /= 10;
      cur = cur.next;
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
