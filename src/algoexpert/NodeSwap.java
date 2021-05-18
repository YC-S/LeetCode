package algoexpert;

public class NodeSwap {
  public LinkedList nodeSwap(LinkedList head) {
    // Write your code here.
    if (head == null || head.next == null) return head;
    LinkedList nextNode = head.next;
    head.next = nodeSwap(head.next.next);
    nextNode.next = head;
    return nextNode;
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
