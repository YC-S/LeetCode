package leetcode500.p17_graph_traversal.plan2;

import java.util.*;

public class P721_AccountsMerge {
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    Map<String, String> emailToName = new HashMap<>();
    Map<String, ArrayList<String>> graph = new HashMap<>();
    for (List<String> account : accounts) {
      String name = "";
      for (String email : account) {
        if (name.equals("")) {
          name = email;
          continue;
        }
        graph.computeIfAbsent(email, x -> new ArrayList<>()).add(account.get(1));
        graph.computeIfAbsent(account.get(1), x -> new ArrayList<>()).add(email);
        emailToName.put(email, name);
      }
    }

    Set<String> seen = new HashSet<>();
    List<List<String>> ans = new ArrayList<>();
    for (String email : graph.keySet()) {
      if (!seen.contains(email)) {
        seen.add(email);
        Deque<String> stack = new ArrayDeque<>();
        stack.offerFirst(email);
        List<String> component = new ArrayList<>();
        while (!stack.isEmpty()) {
          String node = stack.pollFirst();
          component.add(node);
          for (String nei : graph.get(node)) {
            if (!seen.contains(nei)) {
              seen.add(nei);
              stack.offerFirst(nei);
            }
          }
        }
        Collections.sort(component);
        component.add(0, emailToName.get(email));
        ans.add(component);
      }
    }
    return ans;
  }
}
