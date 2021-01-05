package month_challenge._2020_april;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shiyuanchen
 */
public class P10MinStack {
	private final Deque<Integer> stack;
	private final Deque<Integer> minStack;

	/**
	 * initialize your data structure here.
	 */
	public P10MinStack() {
		stack = new ArrayDeque<>();
		minStack = new ArrayDeque<>();
	}

	public void push(int x) {
		stack.offerFirst(x);
		if (minStack.isEmpty() || x <= minStack.peekFirst()) {
			minStack.offerFirst(x);
		}
	}

	public void pop() {
		if (stack.isEmpty()) {
			return;
		}
		Integer res = stack.pollFirst();
		if (!minStack.isEmpty() && minStack.peekFirst().equals(res)) {
			minStack.pollFirst();
		}
	}

	public int top() {
		if (stack.isEmpty()) {
			return -1;
		}
		return stack.peekFirst();
	}

	public int getMin() {
		return minStack.isEmpty() ? -1 : minStack.peekFirst();
	}
}
