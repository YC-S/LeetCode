/*
 * Copyright (c) 2020. Yuanchen
 */

package java8;

import java.util.Arrays;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/09/30
 */
public class F2 {

    public static void main(String[] args) {
        String[] str = {"yang", "guo"};
        List<String> list = Arrays.asList(str);
        str[0] = "cc";
        System.out.println(list);
    }

}
