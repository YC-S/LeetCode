/*
 * Copyright (c) 2020. Yuanchen
 */

package amazon_oa;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/16
 */
class LRUCache2 {

    LRULinkedList list;

    public LRUCache2(int capacity) {
        list = new LRULinkedList(capacity);
    }

    public int get(int key) {
        return list.get(key);
    }

    public void put(int key, int value) {
        list.put(key, value);
    }

    class ListNode {

        int key, val;
        ListNode prev;
        ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class LRULinkedList {

        Map<Integer, ListNode> data;
        ListNode head, tail;
        int size, capacity;

        public LRULinkedList(int capacity) {
            this.capacity = capacity;
            this.data = new HashMap<>();
        }

        public int get(int key) {
            if (!data.containsKey(key)) {
                return -1;
            } else {
                ListNode tmp = data.get(key);
                if (size == 1 || tmp == tail) {
                    return tmp.val;
                }
                if (tmp == head) {
                    head = tmp.next;
                    head.prev = null;
                } else {
                    ListNode prevTmp = tmp.prev;
                    prevTmp.next = tmp.next;
                    tmp.next.prev = prevTmp;
                }
                tail.next = tmp;
                tmp.prev = tail;
                tmp.next = null;
                tail = tmp;
                return tail.val;
            }
        }

        public void put(int key, int val) {
            if (data.containsKey(key)) {//same key
                get(key);
                tail.val = val;
            } else {
                if (size == capacity) {
                    data.remove(head.key);
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null;//capacity==1
                    }
                    --size;
                }
                ListNode tmp = new ListNode(key, val);
                if (size == 0) {
                    head = tmp;
                } else {
                    tail.next = tmp;
                    tmp.prev = tail;
                }
                tail = tmp;
                data.put(key, tmp);
                ++size;
            }
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj = new LRUCache(capacity); int param_1 =
 * obj.get(key); obj.put(key,value);
 */