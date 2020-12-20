/*
 * Copyright (c) 2020. Yuanchen
 */

package jzOffer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/15
 */
public class Duplicate {

    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        //如果数组中有重复的数字，函数返回true，否则返回false。
        //如果数组中有重复的数字，把重复的数字放到参数duplication[0]中。（ps:duplication已经初始化，可以直接赋值使用。）
        Set<Integer> visited = new HashSet<>();
        for (int num : numbers) {
            if (visited.contains(num)) {
                duplication[0] = num;
                return false;
            } else {
                visited.add(num);
            }
        }
        return true;
    }
}
