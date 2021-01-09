/*
 * Copyright (c) 2020. Yuanchen
 */

package book.java8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/09/30
 */
public class F3 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("1".equals(item)) {
                iterator.remove();
            }
        }

        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");
        for (String item : list2) {
            if ("2".equals(item)) {
                list.remove(item);
            }
        }
        System.out.println(list);
        System.out.println(list2);
    }

}
