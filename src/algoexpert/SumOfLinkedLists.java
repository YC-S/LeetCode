package algoexpert;

public class SumOfLinkedLists {
    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // Write your code here.
        LinkedList newHead = new LinkedList(0);
        LinkedList cur = newHead;
        int carry = 0;
        LinkedList nodeOne = linkedListOne;
        LinkedList nodeTwo = linkedListTwo;
        while (nodeOne != null || nodeTwo != null || carry != 0) {
            int valueOne = (nodeOne != null) ? nodeOne.value : 0;
            int valueTwo = (nodeTwo != null) ? nodeTwo.value : 0;
            int sumOfValues = valueOne + valueTwo + carry;

            int newValue = sumOfValues % 10;
            LinkedList newNode = new LinkedList(newValue);
            cur.next = newNode;
            cur = newNode;
            carry = sumOfValues / 10;
            nodeOne = (nodeOne != null) ? nodeOne.next : null;
            nodeTwo = (nodeTwo != null) ? nodeTwo.next : null;
        }
        return newHead.next;
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
