package all_problems;/*
 * Copyright (c) 2020. Yuanchen
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P269_AlienDictionary {

    // ["wrt","wrf","er","ett","rftt"]
    // "wertf"

    StringBuilder strB = new StringBuilder();

    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray())
                graph.putIfAbsent(c, new HashSet<>());
        }

        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];
            int len = Math.min(first.length(), second.length());
            if (first.length() > second.length() && first.startsWith(second))
                return "";

            for (int j = 0; j < len; j++) {
                if (first.charAt(j) != second.charAt(j)) {
                    char in = first.charAt(j);
                    char out = second.charAt(j);
                    graph.get(in).add(out);
                    break;
                }
            }
        }

        int[] visited = new int[26];
        for (char c : graph.keySet()) {
            if (visited[c - 'a'] == 0)
                dfs(c, graph, visited);
        }

        return strB.length() == graph.keySet().size() ? strB.reverse().toString() : "";
    }

    void dfs(char c, Map<Character, Set<Character>> graph, int[] visited) {
        visited[c - 'a'] = 1; //visiting
        for (char nei : graph.get(c)) {
            if (visited[nei - 'a'] == 0)
                dfs(nei, graph, visited);
            else if (visited[nei - 'a'] == 1)
                return;
        }
        visited[c - 'a'] = 2; //Done visting
        strB.append(c);
    }
}
