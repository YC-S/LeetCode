package explore.month_challenge._2021_january.week4;

import utility.ListNode;

import java.util.PriorityQueue;

public class Day3MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        // Time complexity : O(Nlogk) where k is the number of linked lists.
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, (a, b) -> a.val - b.val);

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node : lists)
            if (node != null)
                queue.add(node);

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}
