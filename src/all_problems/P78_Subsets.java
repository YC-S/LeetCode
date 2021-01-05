package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/12
 */
public class P78_Subsets {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());

        Arrays.sort(S);
        for (int i : S) {
            List<List<Integer>> tmp = new ArrayList<>();
            for (List<Integer> sub : res) {
                List<Integer> a = new ArrayList<>(sub);
                a.add(i);
                tmp.add(a);
            }
            res.addAll(tmp);
        }
        return res;
    }
}
