/*
 * Copyright (c) 2020. Yuanchen
 */

package june_challenge;

import utility.ListNode;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/06/02
 */
public class P2DeleteNodeInLinkedList {

  public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
  }
}
