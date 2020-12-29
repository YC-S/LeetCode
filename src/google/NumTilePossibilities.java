package google;

import java.util.HashMap;
import java.util.Map;

public class NumTilePossibilities {
    public static int numTilePossibilities(String tiles) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < tiles.length(); i++) {
            String str = String.valueOf(tiles.charAt(i));
            if (!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, map.get(str) + 1);
            }
        }
        return dfs(map);
    }

    private static int dfs(Map<String, Integer> map) {
        int count = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) continue;
            count++;
            map.put(entry.getKey(), entry.getValue() - 1);
            count += dfs(map);
            map.put(entry.getKey(), entry.getValue() + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAB"));
    }
}
