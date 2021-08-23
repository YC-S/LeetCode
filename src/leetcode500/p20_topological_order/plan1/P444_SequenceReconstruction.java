package leetcode500.p20_topological_order.plan1;

import java.util.*;

public class P444_SequenceReconstruction {
  public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
    if (seqs.size() == 0) return org.length == 0;
    int n = org.length;
    int[] inDegree = new int[n + 1];
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      map.put(i, new ArrayList<>());
    }
    for (List<Integer> seq : seqs) {
      for (int i = 0; i < seq.size(); i++) {
        int origem = seq.get(i);
        if (i < seq.size() - 1) {
          int destination = seq.get(i + 1);
          if (!map.containsKey(destination)) return false;
          map.get(origem).add(destination);
          inDegree[destination]++;
        }
      }
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      if (inDegree[i] == 0) queue.add(i);
    }
    int pos = 0;
    while (!queue.isEmpty()) {
      if (queue.size() > 1) return false;
      int edge = queue.poll();
      if (org[pos] != edge) return false;
      pos++;
      for (int child : map.get(edge)) {
        inDegree[child]--;
        if (inDegree[child] == 0) queue.add(child);
      }
    }
    return pos == n;
  }
}
