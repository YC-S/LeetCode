package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/08
 */
public class P118_PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        } else if (numRows == 1) {
            List<Integer> cur = Arrays.asList(1);
            res.add(cur);
            return res;
        } else if (numRows == 2) {
            List<Integer> cur = Arrays.asList(1);
            List<Integer> cur1 = Arrays.asList(1, 1);
            res.add(cur);
            res.add(cur1);
            return res;
        }
        List<Integer> a = Arrays.asList(1);
        List<Integer> b = Arrays.asList(1, 1);
        res.add(a);
        res.add(b);
        for (int i = 2; i < numRows; ++i) {
            List<Integer> cur = new ArrayList<>();
            List<Integer> prev = res.get(res.size() - 1);
            cur.add(1);
            for (int j = 1; j < prev.size(); ++j) {
                cur.add(prev.get(j) + prev.get(j - 1));
            }
            cur.add(1);
            res.add(cur);
        }
        return res;
    }

}
