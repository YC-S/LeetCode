package leetcode500.p30_randomization.plan1;

import java.util.Random;

public class P382_LinkedListRandomNOde {
  ListNode head;
  Random random;

  public P382_LinkedListRandomNOde(ListNode head) {
    this.head = head;
    random = new Random();
  }

  public int getRandom() {
    ListNode cur = head;
    int val = cur.val;
    for (int i = 1; cur.next != null; i++) {
      cur = cur.next;
      if (random.nextInt(i + 1) == i) val = cur.val;
    }
    return val;
  }
}
