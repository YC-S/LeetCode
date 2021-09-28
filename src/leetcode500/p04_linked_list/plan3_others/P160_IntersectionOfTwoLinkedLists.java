package leetcode500.p04_linked_list.plan3_others;

public class P160_IntersectionOfTwoLinkedLists {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode pA = headA, pB = headB;
    while (pA != pB) {
      pA = pA != null ? pA.next : headB;
      pB = pB != null ? pB.next : headA;
    }
    return pA;
  }
}
