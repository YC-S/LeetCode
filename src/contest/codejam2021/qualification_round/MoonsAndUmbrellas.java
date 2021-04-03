package contest.codejam2021.qualification_round;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MoonsAndUmbrellas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int num = 1;
        while (num <= t) {
            int res = 0;
            int x = sc.nextInt();
            int y = sc.nextInt();
            String str = sc.next();
            // calculate
            // solve(str, x, y);
            char[] arr = str.toCharArray();
            res = solve(arr, x, y);

            System.out.println("Case #" + num + ": " + res);
            num++;
        }
    }

    private static int solve(char[] arr, int x, int y) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        int cnt = 0;
        for (char c : arr) {
            if (c == '?') cnt++;
        }
        dfs(cnt, sb, res, 0);
        List<String> wholeString = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            StringBuilder cur = new StringBuilder();
            int k = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] != '?') {
                    cur.append(arr[j]);
                } else {
                    cur.append(res.get(i).charAt(k++));
                }
            }
            wholeString.add(cur.toString());
        }

        int min = Integer.MAX_VALUE;
        for (String re : wholeString) {
            int cur = 0;
            for (int i = 0; i < re.length() - 1; i++) {
                if (re.substring(i, i + 2).equals("CJ")) {
                    cur += x;
                } else if (re.substring(i, i + 2).equals("JC")) {
                    cur += y;
                }
            }
            min = Math.min(cur, min);
        }
        return min;
    }

    private static void dfs(int cnt, StringBuilder sb, List<String> res, int index) {
        if (index == cnt && sb.length() == cnt) {
            res.add(sb.toString());
            sb = new StringBuilder();
            return;
        }
        for (int i = index; i <= cnt; i++) {
            sb.append('C');
            dfs(cnt, sb, res, i + 1);
            sb.deleteCharAt(sb.length() - 1);
            sb.append('J');
            dfs(cnt, sb, res, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
