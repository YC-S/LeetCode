/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/13
 */
public class P752_OpenTheLock {

    public int openLock(String[] deadends, String target) {
        String source = "0000";
        if (target.equals(source)) {
            return 0;
        }

        Set<String> deadSet = new HashSet();
        for (String dead : deadends) {
            deadSet.add(dead);
        }

        if (deadSet.contains(source) || deadSet.contains(target)) {
            return -1;
        }

        Set<String> beginSet = new HashSet<>();
        beginSet.add(source);
        Set<String> endSet = new HashSet<>();
        endSet.add(target);

        int step = 0;
        while (beginSet.size() > 0 && endSet.size() > 0) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextSet = new HashSet<>();
            step++;

            for (String s : beginSet) {
                // deadSet.add(s);
                for (int i = 0; i < s.length(); i++) {
                    char[] cArr = s.toCharArray();
                    char c = cArr[i];
                    char newChar = cArr[i] == '9' ? '0' : ++cArr[i];
                    cArr[i] = newChar;

                    String newStr = new String(cArr);
                    if (endSet.contains(newStr)) {
                        return step;
                    }
                    if (!deadSet.contains(newStr)) {
                        nextSet.add(newStr);
                    }

                    cArr[i] = c;
                    newChar = cArr[i] == '0' ? '9' : --cArr[i];
                    cArr[i] = newChar;
                    newStr = new String(cArr);
                    if (endSet.contains(newStr)) {
                        return step;
                    }
                    if (!deadSet.contains(newStr)) {
                        nextSet.add(newStr);
                    }
                }
            }

            beginSet = nextSet;
        }

        return -1;
    }
}
