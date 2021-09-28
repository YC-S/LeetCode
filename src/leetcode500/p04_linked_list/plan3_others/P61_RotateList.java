package leetcode500.p04_linked_list.plan3_others;

public class P61_RotateList {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) {
      return head;
    }
    int length = 0;
    ListNode cur1 = head;
    while (cur1 != null) {
      length++;
      cur1 = cur1.next;
    }
    k = length - k % length;
    if (k != length) {
      ListNode newHead = head;
      ListNode dummyHead = new ListNode(0);
      dummyHead.next = newHead;
      for (int i = 0; i < k; i++) {
        dummyHead = dummyHead.next;
        newHead = newHead.next;
      }
      ListNode cur = newHead;
      while (cur != null && cur.next != null) {
        cur = cur.next;
      }
      ListNode cur2 = head;
      while (cur2 != newHead) {
        cur.next = cur2;
        cur = cur.next;
        cur2 = cur2.next;
      }
      dummyHead.next = null;
      return newHead;
    } else {
      return head;
    }
  }
}
