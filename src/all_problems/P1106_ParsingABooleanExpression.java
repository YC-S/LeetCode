package all_problems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class P1106_ParsingABooleanExpression {
    public boolean parseBoolExpr(String expression) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < expression.length(); ++i) {
            char c = expression.charAt(i);
            if (c == ')') {
                Set<Character> seen = new HashSet<>();
                while (stack.peek() != '(')
                    seen.add(stack.pop());
                stack.pop();// pop out '('.
                char operator = stack.pop(); // get operator for current expression.
                if (operator == '&') {
                    stack.push(seen.contains('f') ? 'f' : 't'); // if there is any 'f', & expression results to 'f'
                } else if (operator == '|') {
                    stack.push(seen.contains('t') ? 't' : 'f'); // if there is any 't', | expression results to 't'
                } else { // ! expression.
                    stack.push(seen.contains('t') ? 'f' : 't'); // Logical NOT flips the expression.
                }
            } else if (c != ',') {
                stack.push(c);
            }
        }
        return stack.pop() == 't';
    }

}
