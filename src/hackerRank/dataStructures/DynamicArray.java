/*
 * Copyright (c) 2020. Yuanchen
 */

package hackerRank.dataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/24
 */
public class DynamicArray {

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<List<Integer>> seqList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            seqList.add(new ArrayList<>());
        }

        List<Integer> res = new ArrayList<>();
        int lastAnswer = 0;
        int x = 0, y = 0;
        int type = 1;
        int index = 0;
        for (List<Integer> query : queries) {
            x = query.get(1);
            y = query.get(2);
            type = query.get(0);
            index = ((x ^ lastAnswer) % n);
            if (type == 1) {
                seqList.get(index).add(y);
            } else {
                List<Integer> seq = seqList.get(index);
                lastAnswer = seq.get(y % seq.size());
                res.add(lastAnswer);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> query1 = Arrays.asList(1, 0, 5);
        List<Integer> query2 = Arrays.asList(1, 1, 7);
        List<Integer> query3 = Arrays.asList(1, 0, 3);
        List<Integer> query4 = Arrays.asList(2, 1, 0);
        List<Integer> query5 = Arrays.asList(2, 1, 1);
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(query1);
        queries.add(query2);
        queries.add(query3);
        queries.add(query4);
        queries.add(query5);
        System.out.println(dynamicArray(2, queries));
    }
}
