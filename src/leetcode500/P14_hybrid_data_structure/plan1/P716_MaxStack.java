package leetcode500.P14_hybrid_data_structure.plan1;

import java.util.Stack;

public class P716_MaxStack {
  Stack<Integer> stack;
  Stack<Integer> maxStack;

  public P716_MaxStack() {
    stack = new Stack<>();
    maxStack = new Stack<>();
  }

  public void push(int x) {
    int max = maxStack.isEmpty() ? x : maxStack.peek();
    maxStack.push(Math.max(max, x));
    stack.push(x);
  }

  public int pop() {
    maxStack.pop();
    return stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int peekMax() {
    return maxStack.peek();
  }

  public int popMax() {
    int max = peekMax();
    Stack<Integer> buffer = new Stack<>();
    while (top() != max) buffer.push(pop());
    pop();
    while (!buffer.isEmpty()) push(buffer.pop());
    return max;
  }
}
