package company.uber;

import java.util.*;

public class A {

  public static void main(String[] args) {
    List<List<Integer>> source = new ArrayList<>(2);
    source.add(Arrays.asList(1, 2, 7)); // so do you mean 1 -> 2 -> 7 -> 3 is 3 steps?
    source.add(Arrays.asList(3, 6, 7)); // no he means to create an adjacency matrix.
    System.out.println(new A().solve(source, 1, 6));
  }

  public int solve(List<List<Integer>> sourceInput, int source, int destination) {
    HashSet<Integer> visited = new HashSet<>(); // all the visited bus stations.
    Queue<Integer> q = new LinkedList<>(); // a list of bus stations for current station to visit.
    // it is used for expanding in BFS.
    // map 存的是这些。
    // I am more familiar with using this way to bfs.
    // 1, {2, 7}
    // 3, {6, 7}
    // 2, {1, 7}
    // 6, {3, 7}
    // 7, {1, 2, 3, 6}
    Map<Integer, List<Integer>> map = new HashMap<>();
    // key is the start station
    // value is all the end stations it can arrive

    int res = 0; // result
    if (source == destination) return 0; // 你上面要改造成List<List<Integer>> sourceInput.
    for (int i = 0; i < sourceInput.size(); i++) {
      for (int j = 0; j < sourceInput.get(i).size(); j++) {
        List<Integer> buses = map.getOrDefault(sourceInput.get(i).get(j), new ArrayList<>());
        buses.add(i);
        map.put(sourceInput.get(i).get(j), buses);
      }
    }
    // bfs now source typo not empty
    // so
    q.offer(source); // not empty
    while (!q.isEmpty()) {
      int len = q.size();
      res++; // I have increment the result here.
      for (int i = 0; i < len; i++) {
        int cur = q.poll();
        List<Integer> buses = map.get(cur);
        for (int bus : buses) {
          if (visited.contains(bus)) continue;
          visited.add(bus);
          for (int j = 0; j < sourceInput.get(bus).size(); j++) {
            if (sourceInput.get(bus).get(j) == destination) return res;
            q.offer(sourceInput.get(bus).get(j));
          }
        }
      }
    }
    return -1;
  }
}
