package company.others.heartdub;

import java.util.Arrays;

public class NextGreaterElement {
    static void swap(char ar[], int i, int j) {
        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    // Given a number as a char array number[],
    // this function finds the next greater number.
    // It modifies the same array to store the result
    static int[] findNext(int arr[]) {
        char[] ar = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ar[i] = Character.forDigit(arr[i], 10);
        }
        int i;
        int n = ar.length;
        // I) Start from the right most digit
        // and find the first digit that is smaller
        // than the digit next to it.
        for (i = n - 1; i > 0; i--) {
            if (ar[i] > ar[i - 1]) {
                break;
            }
        }

        // If no such digit is found, then all
        // digits are in descending order means
        // there cannot be a greater number with
        // same set of digits
        int[] res = new int[ar.length];
        if (i == 0) {
            return null;
        } else {
            int x = ar[i - 1], min = i;

            // II) Find the smallest digit on right
            // side of (i-1)'th digit that is greater
            // than number[i-1]
            for (int j = i + 1; j < n; j++) {
                if (ar[j] > x && ar[j] < ar[min]) {
                    min = j;
                }
            }

            // III) Swap the above found smallest
            // digit with number[i-1]
            swap(ar, i - 1, min);

            // IV) Sort the digits after (i-1)
            // in ascending order
            Arrays.sort(ar, i, n);
            for (int k = 0; k < ar.length; k++) {
                res[k] = ar[k] - '0';
            }
        }
        return res;
    }
}
