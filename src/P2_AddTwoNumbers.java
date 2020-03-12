import utility.ListNode;

public class P2_AddTwoNumbers {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		int val = 0;
		while (l1 != null || l2 != null || val != 0) {
			if (l1 != null) {
				val += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				val += l2.val;
				l2 = l2.next;
			}
			ListNode newNode = new ListNode(val % 10);
			val /= 10;
			cur.next = newNode;
			cur = cur.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		l1.next = l2;
		l2.next = l3;

		l4.next = l5;
		l5.next = l6;
		ListNode res = addTwoNumbers(l1, l4);
		while (res != null) {
			System.out.printf("%d ", res.val);
			res = res.next;
		}
	}
}
