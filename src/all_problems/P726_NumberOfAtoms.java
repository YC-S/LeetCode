package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.*;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/10
 */
public class P726_NumberOfAtoms {

    public String countOfAtoms(String formula) {
        int i = 0;
        int len = formula.length();
        Deque<Map<String, Integer>> deque = new ArrayDeque<>();
        Map<String, Integer> map = new HashMap<>();

        while (i < len) {
            char c = formula.charAt(i);
            i++;
            if (c == '(') {
                // we add the current map to the stack
                deque.offerLast(map);
                // and we refresh the map
                map = new HashMap<>();
            } else if (c == ')') {
                // since we have seen a closed brace we now want to get the multiplier after the closed brace e.g. )20 -> 20 is the multiplier
                int multiplier = 0;
                while (i < len && Character.isDigit(formula.charAt(i))) {
                    multiplier = multiplier * 10 + formula.charAt(i) - '0';
                    i++;
                }
                //if we have no digits, the multiplier can simply be 1
                if (multiplier == 0) {
                    multiplier = 1;
                }
                // this is the current map that we are processing, that has the main frequencies that are to be multiplied
                Map<String, Integer> temp = map;
                // this is the initial map
                /*
                The example that illustrates this best is Mg(MgO)2
                in this case, the stack will already contain Mg : 1, and with the (MgO)2, the final value should be Mg : 3
                so we get the element that is in the stack and add its frequency to the multiplied frequency
                */
                map = deque.pollLast();
                for (Map.Entry<String, Integer> e : temp.entrySet()) {
                    String key = e.getKey();
                    Integer value = e.getValue();
                    map.put(key, value * multiplier + map.getOrDefault(key, 0));
                }
            } else {
                // this means that the incoming character is now a digit or a number
                // we are making start as i-1 since the start index of the substring is inclusive
                // this will help with string such as He, where we need to capture H to go along with e.
                int start = i - 1;
                while (i < len && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }

                String s = formula.substring(start, i);
                int val = 0;
                while (i < len && Character.isDigit(formula.charAt(i))) {
                    val = val * 10 + formula.charAt(i) - '0';
                    i++;
                }

                if (val == 0) {
                    val = 1;
                }

                map.put(s, map.getOrDefault(s, 0) + val);

            }
        }
        StringBuilder sb = new StringBuilder();
        List<String> setOfKeys = new ArrayList<>(map.keySet());
        Collections.sort(setOfKeys);
        for (String s : setOfKeys) {
            sb.append(s);
            if (map.get(s) > 1) {
                sb.append(map.get(s));
            }
        }

        return sb.toString();
    }
}
