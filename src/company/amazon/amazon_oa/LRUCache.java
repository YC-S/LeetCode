/*
 * Copyright (c) 2020. Yuanchen
 */

package company.amazon.amazon_oa;

import java.util.Hashtable;

public class LRUCache {

    private final Hashtable<Integer, DoubleLinkedNode>
        cache = new Hashtable<Integer, DoubleLinkedNode>();
    private final int capacity;
    private final DoubleLinkedNode head;
    private final DoubleLinkedNode tail;
    private int count;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DoubleLinkedNode();
        head.pre = null;

        tail = new DoubleLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    /**
     * Always add the new node right after head;
     */
    private void addNode(DoubleLinkedNode node) {

        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(DoubleLinkedNode node) {
        DoubleLinkedNode pre = node.pre;
        DoubleLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(DoubleLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    // pop the current tail.
    private DoubleLinkedNode popTail() {
        DoubleLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    public int get(int key) {

        DoubleLinkedNode node = cache.get(key);
        if (node == null) {
            return -1; // should raise exception here.
        }

        // move the accessed node to the head;
        this.moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkedNode node = cache.get(key);

        if (node == null) {

            DoubleLinkedNode newNode = new DoubleLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);

            ++count;

            if (count > capacity) {
                // pop the tail
                DoubleLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        } else {
            // update the value.
            node.value = value;
            this.moveToHead(node);
        }
    }

    class DoubleLinkedNode {

        int key;
        int value;
        DoubleLinkedNode pre;
        DoubleLinkedNode post;
    }
}