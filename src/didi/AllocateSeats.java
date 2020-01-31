package didi;

public class AllocateSeats {
  public static int solution(int N, String S) {
    int count = 0;
    String[] s = S.split(" ");
    boolean[][] filled = new boolean[N][10];
    for (String str : s) {
      if (str.length() > 2) {
        int x = Integer.parseInt(str.substring(0, 2));
        char y = str.charAt(2);
        if (y == 'K') {
          filled[x - 1][9] = true;
        } else if (y == 'J') {
          filled[x - 1][8] = true;
        } else {
          filled[x - 1][y - 'A'] = true;
        }
      } else {
        int x = Integer.parseInt(str.substring(0, 1));
        char y = str.charAt(1);
        if (y == 'K') {
          filled[x - 1][9] = true;
        } else if (y == 'J') {
          filled[x - 1][8] = true;
        } else {
          filled[x - 1][y - 'A'] = true;
        }
      }
    }
    for (boolean[] tmp : filled) {
      if (!tmp[1] && !tmp[2] && !tmp[3] && !tmp[4]) {
        if (!tmp[5] && !tmp[6] && !tmp[7] && !tmp[8]) {
          count += 2;
        } else {
          count += 1;
        }
      } else if (!tmp[5] && !tmp[6] && !tmp[7] && !tmp[8]) {
        count += 1;
      } else if (!tmp[3] && !tmp[4] && !tmp[5] && !tmp[6]) {
        count += 1;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    String s = "1A 1C 2B 2G";
    System.out.println(solution(3, s));
  }
}
