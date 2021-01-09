package all_problems;

import java.util.*;

public class P1719_NumberOfWaysToReconstructATree {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    boolean[] visit = new boolean[510];
    boolean two = false;
    boolean good = true;

    public int checkWays(int[][] pairs) {
        int root = -1;
        for (int[] pair : pairs) {
            int v1 = pair[0], v2 = pair[1];
            if (!map.containsKey(v1)) map.put(v1, new HashSet<>());
            if (!map.containsKey(v2)) map.put(v2, new HashSet<>());
            map.get(v1).add(v2);
            map.get(v2).add(v1);
        }

        //we try to find a root, the adjecent size shoud be (total vertex-1)
        for (Integer key : map.keySet()) {
            int size = map.get(key).size();
            if (size == map.size() - 1) {
                root = key;
            }
        }


        if (root == -1) return 0;//can not find a root
        visit[root] = true;

        Set<Integer> cur = new HashSet<>();//the current path
        cur.add(root);
        dfs(cur, root);

        if (!good) return 0;
        if (two) return 2;
        return 1;
    }

    public void dfs(Set<Integer> cur, int root) {
        Set<Integer> childs = map.get(root);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return b[1] - a[1];
        });//max heap

        for (Integer next : childs) {
            int cnt = map.get(next).size();//we try to calculate how many childrs/granchilds we have, sort it base on this cnt
            Set<Integer> adjecent = map.get(next);

            for (Integer ancestor : cur) {
                if (!adjecent.contains(ancestor) && !visit[next]) {
                    good = false;
                }
                cnt--;
            }
            pq.add(new int[]{next, cnt});
        }

        while (pq.size() > 0) {
            int[] pair = pq.poll();
            if (visit[pair[0]]) continue;
            visit[pair[0]] = true;
            if (map.get(pair[0]).size() == map.get(root).size()) two = true;
            cur.add(pair[0]);
            dfs(cur, pair[0]);
            cur.remove(pair[0]);
        }

    }
}
