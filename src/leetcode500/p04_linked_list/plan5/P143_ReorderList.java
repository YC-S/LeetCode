package leetcode500.p04_linked_list.plan5;

public class P143_ReorderList {
  public void reorderList(ListNode head) {
    ListNode mid = middleNode(head);
    ListNode midNext = mid.next;
    mid.next = null;
    ListNode right = reverse(midNext);
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (head != null && right != null) {
      cur.next = head;
      head = head.next;
      cur = cur.next;
      cur.next = right;
      right = right.next;
      cur = cur.next;
    }
    if (head != null) {
      cur.next = head;
    }
    head = dummy.next;
  }

  private ListNode middleNode(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
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
