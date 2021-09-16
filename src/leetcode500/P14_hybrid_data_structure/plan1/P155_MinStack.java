package leetcode500.P14_hybrid_data_structure.plan1;

import java.util.Stack;

public class P155_MinStack {
  private final Stack<Integer> stack = new Stack<Integer>();
  // minStack: store the current min values
  private final Stack<Integer> minStack = new Stack<Integer>();

  public void push(int x) {
    // store current min value into minStack
    if (minStack.isEmpty() || x <= minStack.peek()) minStack.push(x);
    stack.push(x);
  }

  public void pop() {
    // use equals to compare the value of two object, if equal, pop both of them
    if (stack.peek().equals(minStack.peek())) minStack.pop();
    stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }
}
