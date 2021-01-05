package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/15
 */
public class P295FindMedian {

    private final PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    private final PriorityQueue<Integer> large = new PriorityQueue<>();
    private boolean flag = true;

    /**
     * initialize your data structure here.
     */
    // small 是maxheap
    // large 是 minheap
    public static void main(String[] args) {
        P295FindMedian solution = new P295FindMedian();
        // 别看屏幕 自己写
        // log(n) + O(1)
        // peek

        // just the opposite of add function.

        // use ArrayList
        // the time complexity is much smaller if we know the index
        // or we could use binary search to search the specific value

        // hard to implement
        // 0, 1, 2, 3, 5
        // median 是 2

        solution.add(5);
        System.out.println(solution.findMedian());
        solution.add(1);
        System.out.println(solution.findMedian());
        solution.add(10);
        // solution 拼错了
        System.out.println(solution.findMedian());
    }
    // 1 2 3 4 5 6 7 8 9 10
    // 1 -》 large,
    // small -> 加

    public void add(int num) {
        if (flag) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        flag = !flag;
    }
// double 不是void
    // 别老看屏幕

    public double findMedian() {
        if (flag) {
            return (small.peek() + large.peek()) / 2.0;
        } else {
            return small.peek();
        }
    }
// even 初始化数字第一个
// 如果是第偶数个数字 就large 加数字 然后small 加large poll出来的
// 如果是第奇数个数字 就small 加数字

    // sort
    // List<>
    // list
    // 然后get the median ()
    // small 是最大堆
    // large 是最小堆
    // 1 2 3 4 5 6 7 8 9 10

    // 最终结果
    // peek the
    // large： 6, 7, 8, 9, 10
    // small： 1, 2, 3, 4, 5

    // 把这些代码说出来啊

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
