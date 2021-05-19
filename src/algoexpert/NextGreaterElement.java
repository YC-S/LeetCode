package algoexpert;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
  public int[] nextGreaterElement(int[] array) {
    // Write your code here.
    int[] result = new int[array.length];
    Arrays.fill(result, -1);

    Stack<Integer> stack = new Stack<Integer>();

    for (int idx = 0; idx < 2 * array.length; idx++) {
      int circularIdx = idx % array.length;

      while (stack.size() > 0 && array[stack.peek()] < array[circularIdx]) {
        int top = stack.pop();
        result[top] = array[circularIdx];
      }

      stack.push(circularIdx);
    }
    return result;
  }
}
