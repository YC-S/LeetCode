package leetcode500.p04_linked_list.plan5;

public class P147_InsertionSortList {
  public ListNode insertionSortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode sortedHead = head, sortedTail = head;
    head = head.next;
    sortedHead.next = null;

    while (head != null) {
      ListNode temp = head;
      head = head.next;
      temp.next = null;

      // new val is less than the head, just insert in the front
      if (temp.val <= sortedHead.val) {
        temp.next = sortedHead;
        sortedTail = sortedHead.next == null ? sortedHead : sortedTail;
        sortedHead = temp;
      }
      // new val is greater than the tail, just insert at the back
      else if (temp.val >= sortedTail.val) {
        sortedTail.next = temp;
        sortedTail = sortedTail.next;
      }
      // new val is somewhere in the middle, we will have to find its proper
      // location.
      else {
        ListNode current = sortedHead;
        while (current.next != null && current.next.val < temp.val) {
          current = current.next;
        }

        temp.next = current.next;
        current.next = temp;
      }
    }

    return sortedHead;
  }
}
