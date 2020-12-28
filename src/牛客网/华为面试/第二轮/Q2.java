package 牛客网.华为面试.第二轮;

import java.util.Stack;

public class Q2 {
    class MyQueue {
        Stack<Integer> input = new Stack();
        Stack<Integer> output = new Stack();

        public void push(int x) {
            input.push(x);
        }

        public void pop() {
            peek();
            output.pop();
        }

        public int peek() {
            if (output.empty())
                while (!input.empty())
                    output.push(input.pop());
            return output.peek();
        }

        // static 都加static
        public boolean empty() {
            return input.empty() && output.empty();
        }
    }
}
