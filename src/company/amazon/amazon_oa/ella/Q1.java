/*
 * Copyright (c) 2020. Yuanchen
 */

package company.amazon.amazon_oa.ella;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/16
 */
public class Q1 {

    static String LexicographicalMaxString(String s) {
        // loop to find the max leicographic
        // substring in the substring data_structures.array
        String max = "";
        for (int i = 0; i < s.length(); ++i) {
            if (max.compareTo(s.substring(i)) <= 0) {
                max = s.substring(i);
            }
        }

        return max;
    }

}
