package leetcode500.p17_graph_traversal.plan4;

import java.util.*;

public class P332_ReconstructItinerary {
  Map<String, PriorityQueue<String>> map = new HashMap<>();
  List<String> res = new ArrayList<>();

  public List<String> findItinerary(List<List<String>> tickets) {
    for (List<String> ticket : tickets) {
      map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
      map.get(ticket.get(0)).offer(ticket.get(1));
    }
    dfs("JFK");
    Collections.reverse(res);
    return res;
  }

  private void dfs(String departure) {
    while (map.containsKey(departure) && !map.get(departure).isEmpty()) {
      dfs(map.get(departure).poll());
    }
    res.add(departure);
  }
}
