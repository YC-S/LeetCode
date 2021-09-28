package leetcode500.p04_linked_list.plan3_others;

public class P708_InsertIntoASortedCircularLinkedList {
  public Node insert(Node head, int insertVal) {
    if (head == null) {
      Node node = new Node(insertVal, null);
      node.next = node;
      return node;
    }
    // if start is not null, try to insert it into correct position
    // 1st pass to find max node
    Node cur = head;
    while (cur.val <= cur.next.val && cur.next != head) cur = cur.next;
    // 2nd pass to insert the node in to correct position
    Node max = cur;
    Node dummy = new Node(0, max.next); // use a dummy head to make insertion process simpler
    max.next = null; // break the cycle
    cur = dummy;
    while (cur.next != null && cur.next.val < insertVal) {
      cur = cur.next;
    }
    cur.next = new Node(insertVal, cur.next); // insert
    Node newMax = max.next == null ? max : max.next; // reconnect to cycle
    newMax.next = dummy.next;
    return head;
  }
}
