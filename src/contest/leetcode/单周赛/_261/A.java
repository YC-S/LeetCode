package contest.leetcode.单周赛._261;

public class A {
    public static int minimumMoves(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int res = 0;
        int i = 0;
        while (i < n) {
            if (arr[i] == 'X') {
                arr[i] = 0;
                res++;
                if (i + 1 < n) {
                    arr[i + 1] = 0;
                } else {
                    break;
                }
                if (i + 2 < n) {
                    arr[i + 2] = 0;
                } else {
                    break;
                }
                i += 3;
            }
            else {
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minimumMoves("XXX"));
        System.out.println(minimumMoves("XX0X"));
        System.out.println(minimumMoves("0000"));
        System.out.println(minimumMoves("0X00X"));
    }
}
