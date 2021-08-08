package leetcode500.p04_linked_list.plan1_reverse;

public class P25_ReverseNodesInKGroup {
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode cur = head;
    int count = 0;
    while (cur != null && count != k) {
      cur = cur.next;
      count++;
    }
    if (count == k) {
      cur = reverseKGroup(cur, k);
      while (count-- > 0) {
        ListNode tmp = head.next;
        head.next = cur;
        cur = head;
        head = tmp;
      }
      head = cur;
    }
    return head;
  }
}
