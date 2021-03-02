package company.wepay;

import java.util.*;

public class SlidingBlock {
    public static void main(String[] args) {
        SlidingBlock solution = new SlidingBlock();
        int[][] board = {{3, 2, 4}, {1, 5, 0}};
        System.out.println(solution.slidingBlock(board));
    }

    public int slidingBlock(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int total = row * col;
        String start = "";
        String end = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < total; i++)
            sb.append((char) (i + 'a'));
        sb.append('a');
        end = sb.toString();
        sb = new StringBuilder();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                sb.append((char) (board[r][c] + 'a'));
            }
        }
        start = sb.toString();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < total; i++) {
            map.put(i, new ArrayList<>());
            if (i % col < col - 1)
                map.get(i).add(i + 1);
            if (i % col > 0)
                map.get(i).add(i - 1);
            if (i + col < total)
                map.get(i).add(i + col);
            if (i - col >= 0)
                map.get(i).add(i - col);
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);

        int cnt = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                if (cur.equals(end)) return cnt;
                int pos = cur.indexOf("a");
                for (int j : map.get(pos)) {
                    String next = get(cur, pos, j);
                    if (visited.contains(next)) continue;
                    visited.add(next);
                    queue.add(next);
                }
            }
            cnt++;
        }
        return -1;
    }

    public String get(String str, int i, int j) {
        char[] arr = str.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }
}
