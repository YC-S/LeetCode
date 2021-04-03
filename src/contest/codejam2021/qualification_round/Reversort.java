package contest.codejam2021.qualification_round;

import java.util.Scanner;

public class Reversort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int x = 1;
        while (x <= t) {
            int l = sc.nextInt();
            int[] arr = new int[l];
            for (int i = 0; i < l; i++) {
                arr[i] = sc.nextInt();
            }
            // calculate
            int res = calculate(arr, l);
            System.out.println("Case #" + x + ": " + res);
            x++;
        }
    }

    private static int calculate(int[] arr, int l) {
        int res = 0;
        for (int i = 0; i < l - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < l; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            res += minIndex - i + 1;
            reverse(arr, i, minIndex);
        }
        return res;
    }

    private static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}
