/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.LinkedList;
import java.util.Queue;

public class P362_DesignHitCounter {

    Queue<Integer> q;

    public P362_DesignHitCounter() {
        this.q = new LinkedList<>();
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        if (!this.q.isEmpty()) {
            while (!this.q.isEmpty() && timestamp > this.q.peek() + 300) {
                this.q.remove();
            }
        }
        this.q.add(timestamp);
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        int count = 0;
        int n = this.q.size();
        for (int i = 0; i < n; i++) {
            if (timestamp - this.q.peek() < 300) {
                count++;
                this.q.add(this.q.poll());
            } else {
                this.q.remove();
            }
        }
        return count;
    }
}
