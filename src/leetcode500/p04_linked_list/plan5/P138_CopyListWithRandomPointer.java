package leetcode500.p04_linked_list.plan5;

import java.util.HashMap;
import java.util.Map;

public class P138_CopyListWithRandomPointer {
  public Node copyRandomList(Node head) {
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
    return map.get(head);
  }
}
