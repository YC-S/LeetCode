package algoexpert;

public class ZipLinkedList {
  public LinkedList zipLinkedList(LinkedList linkedList) {
    if (linkedList.next == null || linkedList.next.next == null) return linkedList;
    LinkedList secondHalfHead = splitLinkedList(linkedList);

    LinkedList reversedSecondHalfHead = reverseLinkedList(secondHalfHead);

    return interweaveLinkedLists(linkedList, reversedSecondHalfHead);
  }

  public LinkedList splitLinkedList(LinkedList linkedList) {
    LinkedList slowIterator = linkedList;
    LinkedList fastIterator = linkedList;
    while (fastIterator != null && fastIterator.next != null) {
      slowIterator = slowIterator.next;
      fastIterator = fastIterator.next.next;
    }
    LinkedList secondHalfHead = slowIterator.next;
    slowIterator.next = null;
    return secondHalfHead;
  }

  public LinkedList interweaveLinkedLists(LinkedList linkedList1, LinkedList linkedList2) {
    LinkedList linkedList1Iterator = linkedList1;
    LinkedList linkedList2Iterator = linkedList2;
    while (linkedList1Iterator != null && linkedList2Iterator != null) {
      LinkedList firstHalfIteratorNext = linkedList1Iterator.next;
      LinkedList secondHalfIteratorNext = linkedList2Iterator.next;
      linkedList1Iterator.next = linkedList2Iterator;
      linkedList2Iterator.next = firstHalfIteratorNext;
      linkedList1Iterator = firstHalfIteratorNext;
      linkedList2Iterator = secondHalfIteratorNext;
    }
    return linkedList1;
  }

  public LinkedList reverseLinkedList(LinkedList linkedList) {
    LinkedList previousNode = null;
    LinkedList currentNode = linkedList;
    while (currentNode != null) {
      LinkedList nextNode = currentNode.next;
      currentNode.next = previousNode;
      previousNode = currentNode;
      currentNode = nextNode;
    }
    return previousNode;
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
