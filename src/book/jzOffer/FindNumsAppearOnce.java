/*
 * Copyright (c) 2020. Yuanchen
 */

package book.jzOffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/16
 */
public class FindNumsAppearOnce {

    public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            if (map.get(num) == 1) {
                list.add(num);
            }
        }
        num1[0] = list.get(0);
        num2[0] = list.get(1);
    }
}
