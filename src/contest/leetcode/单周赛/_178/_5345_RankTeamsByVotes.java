package contest.leetcode.单周赛._178;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class _5345_RankTeamsByVotes {

  public static String rankTeams(String[] votes) {
    if (votes.length == 1) {
      return votes[0];
    }

    HashMap<Character, Integer> map = new HashMap<>();
    for (String vote : votes) {
      for (int i = 0; i < vote.length(); i++) {
        map.put(vote.charAt(i), map.getOrDefault(vote.charAt(i), 0) + 1);
      }
    }

    PriorityQueue<Entry<Character, Integer>> pq = new PriorityQueue<>(
      (o1, o2) -> {
        if (o1.getValue().equals(o2.getValue())) {
          return o1.getKey() - o2.getKey();
        } else {
          return o1.getValue() - o2.getValue();
        }
      }
    );
    pq.addAll(map.entrySet());
    int k = votes[0].length();
    char[] res = new char[k];
    for (int i = 0; i < k; i++) {
      res[i] = pq.poll().getKey();
    }
    return new String(res);
  }

  public static void main(String[] args) {
    String[] votes = {"BCA", "CAB", "CBA", "ABC", "ACB", "BAC"};
    String[] votes2 = {"ABC", "ACB", "ABC", "ACB", "ACB"};
    System.out.println(rankTeams(votes));
    System.out.println(rankTeams(votes2));
  }
}
