/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/12/18
 */
public class P811_SubdomainVisitCount {

    // Input:
    // ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
    // Output:
    // ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]

    public static List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] tmp = cpdomain.split(" ");
            int num = Integer.parseInt(tmp[0]);
            String[] arr = tmp[1].split("\\.");
            for (int i = 0; i < arr.length; ++i) {
                StringBuilder sb = new StringBuilder();
                int j = i;
                for (; j < arr.length - 1; ++j) {
                    sb.append(arr[j]);
                    sb.append(".");
                }
                sb.append(arr[j]);
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + num);
            }
        }
        for (Entry<String, Integer> entry : map.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        String[] cpdomains = {"9001 discuss.leetcode.com"};
        System.out.println(subdomainVisits(cpdomains));
    }
}
