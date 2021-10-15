package leetcode500.p04_linked_list.plan5;

public class P234_PalindromeLinkedList {
  public boolean isPalindrome(ListNode head) {
    if (head == null) return true;
    ListNode mid = middleNode(head);
    ListNode midNext = mid.next;
    mid.next = null;
    ListNode right = reverse(midNext);
    ListNode left = head;
    while (left != null && right != null) {
      if (left.val == right.val) {
        left = left.next;
        right = right.next;
      } else return false;
    }
    return true;
  }

  private ListNode middleNode(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
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
