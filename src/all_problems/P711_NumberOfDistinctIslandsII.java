package all_problems;

import java.util.*;

public class P711_NumberOfDistinctIslandsII {
    boolean[][] visit;

    public int numDistinctIslands2(int[][] grid) {
        visit = new boolean[grid.length][grid[0].length];
        List<List<int[]>> islands = new ArrayList<>();
        Map<Integer, Set<List<List<Integer>>>> map = new HashMap<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (visit[r][c] || grid[r][c] == 0) continue;
                List<int[]> island = new ArrayList<>();
                dfs(grid, r, c, island);
                islands.add(island);
            }
        }

        int cnt = 0;
        for (List<int[]> island : islands) {
            int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
            int top = Integer.MAX_VALUE, down = Integer.MIN_VALUE;
            for (int[] pos : island) {//limit the scope of each island
                int r = pos[0];
                int c = pos[1];
                left = Math.min(left, c);
                right = Math.max(right, c);
                top = Math.min(top, r);
                down = Math.max(down, r);
            }
            int[][] piece = new int[down - top + 1][right - left + 1];
            for (int[] pos : island) {//limit the scope of each island
                int r = pos[0];
                int c = pos[1];
                piece[r - top][c - left] = grid[r][c];
            }
            List<List<Integer>> l1 = convert(piece);
            piece = rotate(piece);
            List<List<Integer>> l2 = convert(piece);
            piece = rotate(piece);
            List<List<Integer>> l3 = convert(piece);
            piece = rotate(piece);
            List<List<Integer>> l4 = convert(piece);
            piece = rotate(piece);
            piece = flipUD(piece);
            List<List<Integer>> l5 = convert(piece);
            piece = rotate(piece);
            List<List<Integer>> l6 = convert(piece);
            piece = rotate(piece);
            List<List<Integer>> l7 = convert(piece);
            piece = rotate(piece);
            List<List<Integer>> l8 = convert(piece);
            boolean found = false;
            for (Integer id : map.keySet()) {
                Set<List<List<Integer>>> preshape = map.get(id);
                if (preshape.contains(l1) || preshape.contains(l2) || preshape.contains(l3) || preshape.contains(l4) || preshape.contains(l5) || preshape.contains(l6) || preshape.contains(l7) || preshape.contains(l8)) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                Set<List<List<Integer>>> set = new HashSet<>();
                set.add(l1);
                set.add(l2);
                set.add(l3);
                set.add(l4);
                set.add(l5);
                set.add(l6);
                set.add(l7);
                set.add(l8);
                map.put(cnt, set);
                cnt++;
            }
        }
        return map.size();
    }

    public int[][] rotate(int[][] grid) {//rotate right 90 degree
        int row = grid.length;
        int col = grid[0].length;
        int[][] res = new int[col][row];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                int correspondR = c;
                int correspondC = row - r - 1;
                res[correspondR][correspondC] = grid[r][c];
            }
        }
        return res;
    }

    public int[][] flipUD(int[][] grid) {//flip up down
        int[][] res = new int[grid.length][grid[0].length];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                res[r][c] = grid[grid.length - 1 - r][c];
            }
        }
        return res;
    }


    public List<List<Integer>> convert(int[][] grid) {//hash a piece of island
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> size = new ArrayList<>();
        size.add(grid.length);
        size.add(grid[0].length);
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) continue;
                List<Integer> l = new ArrayList<>();
                l.add(r);
                l.add(c);
                res.add(l);
            }
        }
        return res;
    }

    public void dfs(int[][] grid, int r, int c, List<int[]> island) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) return;
        if (visit[r][c]) return;
        if (grid[r][c] == 0) return;
        island.add(new int[]{r, c});
        visit[r][c] = true;
        dfs(grid, r + 1, c, island);
        dfs(grid, r - 1, c, island);
        dfs(grid, r, c + 1, island);
        dfs(grid, r, c - 1, island);
    }
}
