package contest.leetcode.双周赛._b_42;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q1 {
    public static int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> queue = new ArrayDeque<>();
        for (int student : students) {
            queue.offerLast(student);
        }
        for (int i = sandwiches.length - 1; i >= 0; --i) {
            stack.offerLast(sandwiches[i]);
        }
        int count = 0;
        int num = 0;
        while (!stack.isEmpty()) {
            if (queue.peekFirst() == stack.peekLast()) {
                queue.pollFirst();
                stack.pollLast();
                count++;
                num = 0;
            } else if (num < queue.size()) {
                queue.offerLast(queue.pollFirst());
                num++;
            } else if (num == queue.size()) {
                break;
            }
        }
        return students.length - count;
    }

    public static void main(String[] args) {
        int[] students = {1, 1, 0, 0};
        int[] sandwiches = {0, 1, 0, 1};
        System.out.println(countStudents(students, sandwiches));
    }
}
