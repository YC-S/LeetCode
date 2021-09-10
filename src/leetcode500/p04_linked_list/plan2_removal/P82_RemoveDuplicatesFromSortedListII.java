package leetcode500.p04_linked_list.plan2_removal;

public class P82_RemoveDuplicatesFromSortedListII {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) return null;
    ListNode dummyHead = new ListNode(-101);
    dummyHead.next = head;
    ListNode pre = dummyHead;
    ListNode cur = head;
    while (cur != null) {
      while (cur.next != null && cur.val == cur.next.val) {
        cur = cur.next;
      }
      if (pre.next == cur) {
        pre = pre.next;
      } else {
        pre.next = cur.next;
      }
      cur = cur.next;
    }
    return dummyHead.next;
  }
}
