/*
 * Copyright (c) 2020. Yuanchen
 */

package contest.leetcode.双周赛._b_40;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/29
 */

class ListNode {

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

public class P1669_MergeBetweenLinkedLists {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode curb = list1;
        while (curb.val != b + 1) {
            curb = curb.next;
        }
        ListNode cura = list1;
        while (cura.val != a - 1) {
            cura = cura.next;
        }
        cura.next = list2;
        ListNode cur = list2;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = curb;
        return list1;
    }

}
