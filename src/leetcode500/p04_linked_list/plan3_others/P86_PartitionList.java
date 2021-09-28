package leetcode500.p04_linked_list.plan3_others;

public class P86_PartitionList {
  public ListNode partition(ListNode head, int x) {
    ListNode dummyLarge = new ListNode(0);
    ListNode large = dummyLarge;
    ListNode dummySmall = new ListNode(0);
    ListNode small = dummySmall;
    while (head != null) {
      if (head.val < x) {
        small.next = head;
        small = small.next;
      } else {
        large.next = head;
        large = large.next;
      }
      head = head.next;
    }
    large.next = null;
    small.next = dummyLarge.next;
    return dummySmall.next;
  }
}
