package leetcode500.P11_PriorityQueue.plan1;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P23_MergeKSortedLists {
  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    for (ListNode node : lists) {
      if (node != null) {
        minHeap.offer(node);
      }
    }
    while (!minHeap.isEmpty()) {
      cur.next = minHeap.poll();
      if (cur.next.next != null) {
        minHeap.offer(cur.next.next);
      }
      cur = cur.next;
    }
    return dummy.next;
  }
}
