/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.month_challenge._2020_july;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/25
 */
public class P24AllPathsFromSourceToTarget {

  private int target;
  private int[][] graph;
  private List<List<Integer>> results;

  protected void backtrack(int currNode, LinkedList<Integer> path) {
    if (currNode == this.target) {
      // Note: one should make a deep copy of the path
      this.results.add(new ArrayList<Integer>(path));
      return;
    }
    // explore the neighbor nodes one after another.
    for (int nextNode : this.graph[currNode]) {
      // mark the choice, before backtracking.
      path.addLast(nextNode);
      this.backtrack(nextNode, path);
      // remove the previous choice, to try the next choice
      path.removeLast();
    }
  }

  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

    this.target = graph.length - 1;
    this.graph = graph;
    this.results = new ArrayList<List<Integer>>();
    // adopt the LinkedList for fast access to the tail element.
    LinkedList<Integer> path = new LinkedList<Integer>();
    path.addLast(0);
    // kick of the backtracking, starting from the source (node 0)
    this.backtrack(0, path);
    return this.results;
  }
}
