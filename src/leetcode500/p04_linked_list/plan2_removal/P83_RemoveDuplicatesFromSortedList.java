package leetcode500.p04_linked_list.plan2_removal;

public class P83_RemoveDuplicatesFromSortedList {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(-101);
    dummy.next = head;
    ListNode prev = dummy;
    while (head != null) {
      while (head != null && head.next != null) {
        if (head.val == head.next.val) {
          head = head.next;
        } else {
          break;
        }
      }
      prev.next = head;
      prev = prev.next;
      head = head.next;
    }
    return dummy.next;
  }
}
