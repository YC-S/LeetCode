/*
 * Copyright (c) 2020. Yuanchen
 */

package java8;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/09/30
 */
public class F4 {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>(16);
        map.put("a", 1);
        map.put(null, 2);
        System.out.println(map.get(null));

        Set<String> set = new TreeSet<>();
        set.add("abc");
        set.add("bcd");
        set.add("a");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
