/*
 * Copyright (c) 2020. Yuanchen
 */

package linked_list_101;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/27
 */
public class Flatten {

  public static NodeFlatten flatten(NodeFlatten head) {
    Deque<NodeFlatten> stack = new ArrayDeque<>();
    NodeFlatten cur = head;
    if (head == null) {
      return head;
    }
    while (cur != null && cur.next != null || cur.child != null) {
      if (cur.child != null) {
        if (cur.next != null) {
          stack.offerFirst(cur.next);
          cur.next = cur.child;
          NodeFlatten curChild = cur.child;
          curChild.prev = cur;
          cur.child = null;
          cur = curChild;
        } else {
          cur.next = cur.child;
          NodeFlatten curChild = cur.child;
          curChild.prev = cur;
          cur.child = null;
          cur = curChild;
        }
      } else {
        cur = cur.next;
      }
    }
    while (!stack.isEmpty()) {
      NodeFlatten tmp = stack.pollFirst();
      if (tmp != null) {
        cur.next = tmp;
        tmp.prev = cur;
        cur = tmp;
        while (cur != null && cur.next != null) {
          cur = cur.next;
        }
      }
    }
    return head;

  }

  public static void main(String[] args) {
    NodeFlatten nodeFlatten1 = new NodeFlatten(1);
    NodeFlatten nodeFlatten2 = new NodeFlatten(2);
    NodeFlatten nodeFlatten3 = new NodeFlatten(3);
    NodeFlatten nodeFlatten4 = new NodeFlatten(4);
    NodeFlatten nodeFlatten5 = new NodeFlatten(5);
    NodeFlatten nodeFlatten6 = new NodeFlatten(6);
    NodeFlatten nodeFlatten7 = new NodeFlatten(7);
    NodeFlatten nodeFlatten8 = new NodeFlatten(8);
    NodeFlatten nodeFlatten9 = new NodeFlatten(9);
    NodeFlatten nodeFlatten10 = new NodeFlatten(10);
    NodeFlatten nodeFlatten11 = new NodeFlatten(11);
    NodeFlatten nodeFlatten12 = new NodeFlatten(12);
    nodeFlatten1.next = nodeFlatten2;
    nodeFlatten2.next = nodeFlatten3;
    nodeFlatten3.next = nodeFlatten4;
    nodeFlatten4.next = nodeFlatten5;
    nodeFlatten5.next = nodeFlatten6;
    nodeFlatten7.next = nodeFlatten8;
    nodeFlatten8.next = nodeFlatten9;
    nodeFlatten9.next = nodeFlatten10;
    nodeFlatten11.next = nodeFlatten12;
    nodeFlatten3.child = nodeFlatten7;
    nodeFlatten8.child = nodeFlatten11;
    nodeFlatten2.prev = nodeFlatten1;
    nodeFlatten3.prev = nodeFlatten2;
    nodeFlatten4.prev = nodeFlatten3;
    nodeFlatten5.prev = nodeFlatten4;
    nodeFlatten6.prev = nodeFlatten5;
    nodeFlatten8.prev = nodeFlatten7;
    nodeFlatten9.prev = nodeFlatten8;
    nodeFlatten10.prev = nodeFlatten9;
    nodeFlatten12.prev = nodeFlatten11;
    NodeFlatten result = flatten(nodeFlatten1);
    while (result != null) {
      result = result.next;
      System.out.println(result.val);
    }
  }
}
