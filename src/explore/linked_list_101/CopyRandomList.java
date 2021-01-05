/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.linked_list_101;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/08/27
 */
public class CopyRandomList {

  public static Node copyRandomList(Node head) {
    Map<Node, Node> map = new HashMap<>();
    Node node = head;
    while (node != null) {
      map.put(node, new Node(node.val));
      node = node.next;
    }
    node = head;
    while (node != null) {
      map.get(node).next = map.get(node.next);
      map.get(node).random = map.get(node.random);
      node = node.next;
    }
    return head;
  }

  public static void main(String[] args) {
    Node node1 = new Node(7);
    Node node2 = new Node(13);
    Node node3 = new Node(11);
    Node node4 = new Node(10);
    Node node5 = new Node(1);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node1.random = null;
    node2.random = node1;
    node3.random = node5;
    node4.random = node3;
    node5.random = node1;
    Node result = copyRandomList(node1);
    while (result != null) {
      System.out.println(result.random.val);
      result = result.next;
    }
  }
}
