package company.wepay;

import java.util.Stack;

public class EvalRPN {
    public static int evalRPN(String[] tokens) throws Exception {
        Stack<Integer> tokenStack = new Stack<Integer>();

        if (tokens.length == 1) {
            if ((tokens[0].matches("-[0-9]+")) || (tokens[0].matches("[0-9]+"))) {
                return Integer.parseInt(tokens[0]);
            } else {
                throw new IllegalArgumentException("invalid inputs");
            }
        }

        if ((tokens.length % 2) == 0) {
            throw new IllegalArgumentException("invalid inputs");
        }

        for (String s : tokens) {
            if ((s.matches("[0-9]+")) || (s.matches("-[0-9]+"))) {
                tokenStack.push(Integer.parseInt(s));
            } else {
                int a = tokenStack.pop();
                int b = tokenStack.pop();

                if (s.equals("*")) {
                    tokenStack.push(a * b);
                } else if (s.equals("/")) {
                    if (a == 0) {
                        throw new IllegalArgumentException("invalid inputs");
                    }
                    tokenStack.push(b / a);
                } else if (s.equals("%")) {
                    if (a == 0) {
                        throw new IllegalArgumentException("invalid inputs");
                    }
                    tokenStack.push(b % a);
                } else if (s.equals("-")) {
                    tokenStack.push(b - a);
                } else if (s.equals("+")) {
                    tokenStack.push(a + b);
                }
            }
        }
        return tokenStack.pop();
    }

    public static void main(String[] args) {
        try {
            System.out.println(evalRPN(new String[]{"22", "1", "+", "3", "*"}));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
