package company.byteDance;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.TreeMap;

public class P726_NumberOfAtoms {
    public String countOfAtoms(String formula) {
        int n = formula.length();
        Deque<Map<String, Integer>> stack = new ArrayDeque<>();
        stack.offerFirst(new TreeMap<>());

        int i = 0;
        while (i < n) {
            if (formula.charAt(i) == '(') {
                stack.offerFirst(new TreeMap<>());
                i++;
            } else if (formula.charAt(i) == ')') {
                Map<String, Integer> top = stack.pollFirst();
                int iStart = ++i;
                int multiplicity = 1;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                if (i > iStart) {
                    multiplicity = Integer.parseInt(formula.substring(iStart, i));
                }
                for (String c : top.keySet()) {
                    int v = top.get(c);
                    stack.peekFirst().put(c, stack.peekFirst().getOrDefault(c, 0) + v * multiplicity);
                }
            } else {
                int iStart = i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String name = formula.substring(iStart, i);
                iStart = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int multiplicity = i > iStart ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                stack.peekFirst().put(name, stack.peekFirst().getOrDefault(name, 0) + multiplicity);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String name : stack.peekFirst().keySet()) {
            sb.append(name);
            int multiplicity = stack.peekFirst().get(name);
            if (multiplicity > 1) {
                sb.append("" + multiplicity);
            }
        }
        return sb.toString();
    }
}
