package all_problems;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class P1244_DesignALeaderboard {
    Map<Integer, Integer> map;
    TreeMap<Integer, Integer> sorted;

    public P1244_DesignALeaderboard() {
        map = new HashMap<>();
        sorted = new TreeMap<>(Collections.reverseOrder());
    }

    public void addScore(int playerId, int score) {
        if (!map.containsKey(playerId)) {
            map.put(playerId, score);
            sorted.put(score, sorted.getOrDefault(score, 0) + 1);
        } else {
            int preScore = map.get(playerId);
            sorted.put(preScore, sorted.get(preScore) - 1);
            if (sorted.get(preScore) == 0) {
                sorted.remove(preScore);
            }
            int newScore = preScore + score;
            map.put(playerId, newScore);
            sorted.put(newScore, sorted.getOrDefault(newScore, 0) + 1);
        }
    }

    public int top(int K) {
        int count = 0;
        int sum = 0;
        for (int key : sorted.keySet()) {
            int times = sorted.get(key);
            for (int i = 0; i < times; i++) {
                sum += key;
                count++;
                if (count == K) {
                    break;
                }
            }
            if (count == K) {
                break;
            }
        }
        return sum;
    }

    public void reset(int playerId) {
        int preScore = map.get(playerId);
        sorted.put(preScore, sorted.get(preScore) - 1);
        if (sorted.get(preScore) == 0) {
            sorted.remove(preScore);
        }
        map.remove(playerId);
    }
}
