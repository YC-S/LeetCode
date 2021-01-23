package all_problems;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class P1210_MinimumMovesToReachTargetWithRotations {
    public int minimumMoves(int[][] grid) {
        int n = grid.length;
        int[][] pos = {{0, 0}, {0, 1}, {0}};
        PriorityQueue<int[][]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2][0], b[2][0]));
        Set<String> visited = new HashSet<>();
        pq.offer(pos);
        visited.add(toString(pos));
        while (!pq.isEmpty()) {
            int[][] cur = pq.poll();
            if (cur[0][0] == n - 1 && cur[0][1] == n - 2 && cur[1][0] == n - 1 && cur[1][1] == n - 1) {
                return cur[2][0];
            }
            int[][] next1 = moveRight(cur, n, grid);
            int[][] next2 = moveDown(cur, n, grid);
            int[][] next3 = rotate(cur, n, grid);
            int[][] next4 = rotatec(cur, n, grid);
            if (next1 != null) {
                if (visited.add(toString(next1))) {
                    pq.offer(next1);
                }
            }
            if (next2 != null) {
                if (visited.add(toString(next2))) {
                    pq.offer(next2);
                }
            }
            if (next3 != null) {
                if (visited.add(toString(next3))) {
                    pq.offer(next3);
                }
            }
            if (next4 != null) {
                if (visited.add(toString(next4))) {
                    pq.offer(next4);
                }
            }
        }
        return -1;
    }

    private String toString(int[][] cur) {
        return cur[0][0] + " " + cur[0][1] + " " + cur[1][0] + " " + cur[1][1];
    }

    private int[][] clone(int[][] cur) {
        return new int[][]{{cur[0][0], cur[0][1]}, {cur[1][0], cur[1][1]}, {cur[2][0]}};
    }

    private int[][] moveRight(int[][] cur, int n, int[][] grid) {
        int[][] next = clone(cur);
        next[0][1]++;
        next[1][1]++;
        if (next[0][1] >= n || next[1][1] >= n) {
            return null;
        }
        if (grid[next[0][0]][next[0][1]] == 1) {
            return null;
        }
        if (grid[next[1][0]][next[1][1]] == 1) {
            return null;
        }
        next[2][0]++;
        return next;
    }

    private int[][] moveDown(int[][] cur, int n, int[][] grid) {
        int[][] next = clone(cur);
        next[0][0]++;
        next[1][0]++;
        if (next[0][0] >= n || next[1][0] >= n) {
            return null;
        }
        if (grid[next[0][0]][next[0][1]] == 1) {
            return null;
        }
        if (grid[next[1][0]][next[1][1]] == 1) {
            return null;
        }
        next[2][0]++;
        return next;
    }

    private int[][] rotate(int[][] cur, int n, int[][] grid) {
        int[][] next = clone(cur);
        if (cur[0][0] == cur[1][0] && cur[0][1] + 1 == cur[1][1]) {
            if (cur[0][0] + 1 >= n) {
                return null;
            }
            if (grid[cur[0][0] + 1][cur[0][1]] == 1) {
                return null;
            }
            if (grid[cur[1][0] + 1][cur[1][1]] == 1) {
                return null;
            }
            next[1][0]++;
            next[1][1]--;
            next[2][0]++;
            return next;
        }
        return null;
    }

    private int[][] rotatec(int[][] cur, int n, int[][] grid) {
        int[][] next = clone(cur);
        if (cur[0][0] + 1 == cur[1][0] && cur[0][1] == cur[1][1]) {
            if (cur[0][1] + 1 >= n) {
                return null;
            }
            if (grid[cur[0][0]][cur[0][1] + 1] == 1) {
                return null;
            }
            if (grid[cur[1][0]][cur[1][1] + 1] == 1) {
                return null;
            }
            next[1][0]--;
            next[1][1]++;
            next[2][0]++;
            return next;
        }
        return null;
    }
}
