package company.wepay;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvalRPN1 {
    public static int evalRPN(String[] tokens) throws Exception {
        Deque<Integer> s = new ArrayDeque<>();
        for (String t : tokens) {
            // if t is √
            if (t.equals("√")) {
                int tmp;
                try {
                    tmp = Integer.valueOf(s.pollFirst());
                } catch (Exception e) {
                    throw e;
                }
                if (tmp <= 0) {
                    throw new ArithmeticException("can not square root non-positive number");
                }
                s.offerFirst((int) Math.sqrt(tmp));
            }
            // only consider two operands:
            else if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
                int right, left;
                try {
                    right = Integer.valueOf(s.pollFirst());
                } catch (Exception e) {
                    throw e;
                }
                try {
                    left = Integer.valueOf(s.pollFirst());
                } catch (Exception e) {
                    throw e;
                }

                switch (t) {
                    case "+":
                        s.offerFirst(left + right);
                        break;
                    case "-":
                        s.offerFirst(left - right);
                        break;
                    case "*":
                        s.offerFirst(left * right);
                        break;
                    case "/":
                        if (right == 0) {
                            throw new ArithmeticException("can not divide by zero");
                        }
                        s.offerFirst(left / right);
                        break;
                }
            } else
                s.offerFirst(Integer.valueOf(t));
        }
        return s.pollFirst();
    }

    public static void main(String[] args) {
        try {
            System.out.println(evalRPN(new String[]{"2", "1", "+", "-3", "*", "√"}));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


