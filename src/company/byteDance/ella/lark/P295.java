package company.byteDance.ella.lark;

import java.util.Collections;
import java.util.PriorityQueue;

public class P295 {
    class MedianFinder {
        // max queue is always larger or equal to min queue
        // min queue holds the larger elements of the stream with the ability to provide the least element in it in O(1)
        // max queue holds the smaller elements of the stream with the ability to provide the largest element in it in O(1)
        PriorityQueue<Integer> min = new PriorityQueue();
        PriorityQueue<Integer> max = new PriorityQueue(1000, Collections.reverseOrder());

        // Adds a number into the data structure.
        public void addNum(int num) {
            max.offer(num);
            min.offer(max.poll());
            if (max.size() < min.size()) {
                max.offer(min.poll());
            }
        }

        // Returns the median of current data stream
        public double findMedian() {
            if (max.size() == min.size()) return (max.peek() + min.peek()) / 2.0;
            else return max.peek();
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
