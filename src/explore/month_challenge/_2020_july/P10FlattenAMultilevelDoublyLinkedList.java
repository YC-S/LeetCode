/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.month_challenge._2020_july;

import utility.Node;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/10
 */
public class P10FlattenAMultilevelDoublyLinkedList {

  public Node flatten(Node head) {
    if (head == null) {
      return head;
    }
    // pseudo head to ensure the `prev` pointer is never none
    Node pseudoHead = new Node(0, null, head, null);

    flattenDFS(pseudoHead, head);

    // detach the pseudo head from the real head
    pseudoHead.next.prev = null;
    return pseudoHead.next;
  }

  /* return the tail of the flatten list */
  public Node flattenDFS(Node prev, Node curr) {
    if (curr == null) {
      return prev;
    }
    curr.prev = prev;
    prev.next = curr;

    // the curr.next would be tempered in the recursive function
    Node tempNext = curr.next;

    Node tail = flattenDFS(curr, curr.child);
    curr.child = null;

    return flattenDFS(tail, tempNext);
  }
}
