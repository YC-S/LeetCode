package algoexpert;

public class LinkedListPalindrome {
  public boolean linkedListPalindrome(LinkedList head) {
    LinkedListInfo isPalindromeResults = isPalindrome(head, head);
    return isPalindromeResults.outerNodesAreEqual;
  }

  public LinkedListInfo isPalindrome(LinkedList leftNode, LinkedList rightNode) {
    if (rightNode == null) return new LinkedListInfo(true, leftNode);
    LinkedListInfo recursiveCallResults = isPalindrome(leftNode, rightNode.next);
    LinkedList leftNodeToCompare = recursiveCallResults.leftNodeToCompare;
    boolean outerNodesAreEqual = recursiveCallResults.outerNodesAreEqual;

    boolean recursiveIsEqual = outerNodesAreEqual && (leftNodeToCompare.value == rightNode.value);
    LinkedList nextLeftNodeToCompare = leftNodeToCompare.next;

    return new LinkedListInfo(recursiveIsEqual, nextLeftNodeToCompare);
  }

  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public static class LinkedListInfo {
    public boolean outerNodesAreEqual;
    public LinkedList leftNodeToCompare;

    public LinkedListInfo(boolean outerNodesAreEqual, LinkedList leftNodeToCompare) {
      this.outerNodesAreEqual = outerNodesAreEqual;
      this.leftNodeToCompare = leftNodeToCompare;
    }
  }
}
