/*
 * Copyright (c) 2020. Yuanchen
 */

package company.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/11/14
 */
public class CriticalConnections {

    int T = 1;

    public static void main(String[] args) {
        CriticalConnections solution = new CriticalConnections();
        int n = 4;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));
        System.out.println(solution.criticalConnections(n, connections));
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // use a timestamp, for each node, check the samllest timestamp that can reach from the node
        // construct the graph first
        List[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (List<Integer> conn : connections) {
            graph[conn.get(0)].add(conn.get(1));
            graph[conn.get(1)].add(conn.get(0));
        }

        int[] timestamp = new int[n]; // an data_structures.array to save the timestamp that we meet a certain node

        // for each node, we need to run dfs for it, and return the smallest timestamp in all its children except its parent
        List<List<Integer>> criticalConns = new ArrayList<>();
        dfs(n, graph, timestamp, 0, -1, criticalConns);
        return criticalConns;
    }

    // return the minimum timestamp it ever visited in all the neighbors
    private int dfs(int n, List[] graph, int[] timestamp, int i, int parent, List<List<Integer>> criticalConns) {
        if (timestamp[i] != 0) {
            return timestamp[i];
        }
        timestamp[i] = T++;

        int minTimestamp = Integer.MAX_VALUE;
        for (int neighbor : (List<Integer>) graph[i]) {
            if (neighbor == parent) {
                continue; // no need to check the parent
            }
            int neighborTimestamp = dfs(n, graph, timestamp, neighbor, i, criticalConns);
            minTimestamp = Math.min(minTimestamp, neighborTimestamp);
        }

        if (minTimestamp >= timestamp[i]) {
            if (parent >= 0) {
                criticalConns.add(Arrays.asList(parent, i));
            }
        }
        return Math.min(timestamp[i], minTimestamp);
    }
}
