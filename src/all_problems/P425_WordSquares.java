package all_problems;

import java.util.*;

public class P425_WordSquares {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ret = new ArrayList<List<String>>();
        if (words.length == 0 || words[0].length() == 0) return ret;
        Map<String, Set<String>> map = new HashMap<>();
        int squareLen = words[0].length();
        // create all prefix
        for (int i = 0; i < words.length; i++) {
            for (int j = -1; j < words[0].length(); j++) {
                if (!map.containsKey(words[i].substring(0, j + 1)))
                    map.put(words[i].substring(0, j + 1), new HashSet<String>());
                map.get(words[i].substring(0, j + 1)).add(words[i]);
            }
        }
        helper(ret, new ArrayList<String>(), 0, squareLen, map);
        return ret;
    }

    public void helper(List<List<String>> ret, List<String> cur, int matched, int total, Map<String, Set<String>> map) {
        if (matched == total) {
            ret.add(new ArrayList<String>(cur));
            return;
        }
        // build search string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= matched - 1; i++) sb.append(cur.get(i).charAt(matched));
        // bachtracking
        Set<String> cand = map.get(sb.toString());
        if (cand == null) return;
        for (String str : cand) {
            cur.add(str);
            helper(ret, cur, matched + 1, total, map);
            cur.remove(cur.size() - 1);
        }
    }
}
