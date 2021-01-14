package all_problems;

public class P691_StickersToSpellWord {
    int[][] countMap; //map[i][j] means the number of character (j + 'a') contains in the ith element of stickers...
    int cnt = Integer.MAX_VALUE;

    public int minStickers(String[] stickers, String target) {
        if (target == null) return -1;
        if (target.length() == 0) return 0;
        if (stickers == null || stickers.length == 0) return -1;

        int m = stickers.length;
        countMap = new int[m][26];

        for (int i = 0; i < stickers.length; i++) {
            String s = stickers[i];
            for (char c : s.toCharArray()) {
                countMap[i][c - 'a']++;
            }
        }
        count(0, 0, new int[26], target, stickers);
        return cnt == Integer.MAX_VALUE ? -1 : cnt;
    }

    private void count(int curCnt, int pos, int[] charAvailable, String target, String[] stickers) {
        if (curCnt >= cnt) return; //prune the search, when curCnt will be larger then cnt...
        //important step... other wise will get TLE..
        int m = stickers.length, n = target.length();
        if (pos == n) {
            cnt = Math.min(cnt, curCnt);
            return;
        }
        char c = target.charAt(pos);
        if (charAvailable[c - 'a'] > 0) {
            charAvailable[c - 'a']--;
            count(curCnt, pos + 1, charAvailable, target, stickers);
            charAvailable[c - 'a']++;
        } else {
            for (int i = 0; i < m; i++) {
                if (countMap[i][c - 'a'] == 0) continue;
                for (int j = 0; j < 26; j++) {
                    charAvailable[j] += countMap[i][j];
                }
                count(curCnt + 1, pos, charAvailable, target, stickers);
                for (int j = 0; j < 26; j++) {
                    charAvailable[j] -= countMap[i][j];
                }
            }
        }
    }
}
