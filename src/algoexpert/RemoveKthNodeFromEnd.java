package algoexpert;

public class RemoveKthNodeFromEnd {

    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        // Write your code here.
        int counter = 1;
        LinkedList first = head;
        LinkedList second = head;
        while (counter <= k) {
            second = second.next;
            counter++;
        }
        if (second == null && head != null) {
            head.value = head.next.value;
            head.next = head.next.next;
            return;
        }
        while (second != null && second.next != null) {
            second = second.next;
            first = first.next;
        }
        if (first != null) {
            first.next = first.next.next;
        }
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}

