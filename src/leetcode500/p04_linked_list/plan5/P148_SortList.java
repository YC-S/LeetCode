package leetcode500.p04_linked_list.plan5;

public class P148_SortList {
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode mid = middleNode(head);

    ListNode l1 = sortList(head);
    ListNode l2 = sortList(mid);

    return merge(l1, l2);
  }

  private ListNode middleNode(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode prev = null, slow = head, fast = head;
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    prev.next = null;
    return slow;
  }

  private ListNode merge(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        cur.next = l1;
        l1 = l1.next;
      } else {
        cur.next = l2;
        l2 = l2.next;
      }
      cur = cur.next;
    }
    if (l1 != null) {
      cur.next = l1;
    }
    if (l2 != null) {
      cur.next = l2;
    }
    return dummy.next;
  }
}
