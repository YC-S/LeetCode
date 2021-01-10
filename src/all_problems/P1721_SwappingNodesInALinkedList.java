package all_problems;

public class P1721_SwappingNodesInALinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = head;
        int count = 1;
        while (first != null) {
            if (count == k) {
                break;
            }
            first = first.next;
            count++;
        }
        ListNode second = head;
        count = 1;
        while (second != null) {
            count++;
            second = second.next;
        }
        int target = count - k;
        count = 1;
        second = head;
        while (second != null) {
            if (count == target) {
                break;
            }
            second = second.next;
            count++;
        }
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
        return head;
    }
}
