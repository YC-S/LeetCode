package all_problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class P1597_BuildBinaryExpressionTreeFromInfixExpression {
    public Node expTree(String s) {
        Deque<Node> nodes = new ArrayDeque<>();
        Deque<Character> op = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                nodes.push(new Node(c));
            } else if (c == '(') {
                op.push(c);
            } else if (c == ')') {
                collapseUntilLeftParen(nodes, op);
            } else {
                collapse(nodes, op, c);
            }
        }
        collapseAll(nodes, op);
        return nodes.pop();
    }

    private boolean shouldCollapse(Deque<Character> op, char c) {
        if (op.isEmpty()) {
            return false;
        }
        if (op.peek() == '(') {
            return false;
        }
        return (op.peek() != '+' && op.peek() != '-') || (c != '*' && c != '/');
    }

    private void collapseUntilLeftParen(Deque<Node> nodes, Deque<Character> op) {
        while (op.peek() != '(') {
            doCollapse(nodes, op);
        }
        op.pop(); // pop up the left bracket
    }

    private void collapse(Deque<Node> nodes, Deque<Character> op, char c) {
        while (shouldCollapse(op, c)) {
            // need a while because if it's 1+2*3*4*5 + 6 and we are at the last +then all the calculations before it can be collapsed
            doCollapse(nodes, op);
        }
        op.push(c);
    }

    private void collapseAll(Deque<Node> nodes, Deque<Character> op) {
        while (nodes.size() > 1) {
            doCollapse(nodes, op);
        }
    }

    private void doCollapse(Deque<Node> nodes, Deque<Character> op) {
        Node n1 = nodes.pop();
        Node n2 = nodes.pop();
        Node cur = new Node(op.pop());
        cur.left = n2; // n1== right operand is at the top hence n2 is left tree
        cur.right = n1;
        nodes.push(cur);
    }

    static class Node {
        char val;
        Node left;
        Node right;

        Node() {
            this.val = ' ';
        }

        Node(char val) {
            this.val = val;
        }

        Node(char val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
