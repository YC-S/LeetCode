package all_problems;

import java.util.Random;

public class P382_LinkedListRandomNode {
    ListNode head;
    Random random;

    public P382_LinkedListRandomNode(ListNode h) {
        head = h;
        random = new Random();
    }

    public int getRandom() {

        ListNode c = head;
        int r = c.val;
        for (int i = 1; c.next != null; i++) {

            c = c.next;
            if (random.nextInt(i + 1) == i) r = c.val;
        }

        return r;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
