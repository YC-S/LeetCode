package leetcode500.p04_linked_list.plan5;

public class P328_OddEvenLinkedList {
  public ListNode oddEvenList(ListNode head) {
    ListNode dummyOdd = new ListNode(0);
    ListNode curOdd = dummyOdd;
    ListNode dummyEven = new ListNode(0);
    ListNode curEven = dummyEven;
    int count = 0;

    while (head != null) {
      count++;
      if (count % 2 == 0) {
        curEven.next = head;
        curEven = curEven.next;
      } else {
        curOdd.next = head;
        curOdd = curOdd.next;
      }
      head = head.next;
    }
    if (count % 2 == 0) {
      curEven.next = null;
    } else {
      curOdd.next = null;
    }

    curOdd.next = dummyEven.next;
    return dummyOdd.next;
  }
}
