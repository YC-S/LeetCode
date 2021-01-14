package all_problems;

import java.util.*;

public class P737_SentenceSimilarityII {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        // for each word, do a dfs
        //return dfs(words1, words2, pairs);
        return unionFind(words1, words2, pairs);
    }

    private boolean unionFind(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        Map<String, String> map = new HashMap<>();
        for (List<String> p : pairs) {
            String s1 = p.get(0);
            String s2 = p.get(1);
            map.putIfAbsent(s1, s1);
            map.putIfAbsent(s2, s2);
            String p1 = find(s1, map);
            String p2 = find(s2, map);
            if (!p1.equals(p2)) {
                map.put(p2, p1);
            }
        }
        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) {
                continue;
            }
            if (!map.containsKey(words1[i]) || !map.containsKey(words2[i])) {
                return false;
            }
            String p1 = find(words1[i], map);
            String p2 = find(words2[i], map);
            if (!p1.equals(p2)) {
                return false;
            }
        }
        return true;
    }

    private String find(String s, Map<String, String> map) {
        while (map.containsKey(s) && !map.get(s).equals(s)) {
            s = map.get(s);
        }
        return s;
    }

    private boolean dfs(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> p : pairs) {
            String s1 = p.get(0);
            String s2 = p.get(1);
            map.putIfAbsent(s1, new HashSet<>());
            map.putIfAbsent(s2, new HashSet<>());
            map.get(s1).add(s2);
            map.get(s2).add(s1);
        }
        for (int i = 0; i < words1.length; i++) {
            String s1 = words1[i];
            String s2 = words2[i];
            if (s1.equals(s2)) {
                continue;
            }
            boolean temp = helper(s1, s2, map, new HashSet<>());
            if (!temp) {
                return false;
            }
        }
        return true;
    }

    private boolean helper(String s1, String s2, Map<String, Set<String>> map, Set<String> visited) {
        if (s1.equals(s2)) {
            return true;
        }
        if (!map.containsKey(s1) || visited.contains(s1)) {
            return false;
        }
        if (map.get(s1).contains(s2)) {
            return true;
        }
        visited.add(s1);
        for (String next : map.get(s1)) {
            if (helper(next, s2, map, visited)) {
                visited.remove(s1);
                return true;
            }
        }
        visited.remove(s1);
        return false;
    }
}
